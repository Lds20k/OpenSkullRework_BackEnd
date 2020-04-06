package com.teamrogerio.openskullrework.usecase;

import com.teamrogerio.openskullrework.controller.exception.FileIsNotCompatibleException;
import com.teamrogerio.openskullrework.controller.exception.PersonDoesNotExistsException;
import com.teamrogerio.openskullrework.controller.exception.ProblemsToUploadImageException;
import com.teamrogerio.openskullrework.controller.model.PersonResponse;
import com.teamrogerio.openskullrework.controller.translator.Translator;
import com.teamrogerio.openskullrework.entities.Person;
import com.teamrogerio.openskullrework.gateway.mongodb.model.PersonDBDomain;
import com.teamrogerio.openskullrework.gateway.mongodb.repository.FindPersonByIdGateway;
import com.teamrogerio.openskullrework.gateway.mongodb.repository.UpdatePersonGateway;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class SavePersonImageUseCase {

    private final FindPersonByIdGateway findPersonByIdGateway;
    private final UpdatePersonGateway updatePersonGateway;
    private final VerifyFileCompatibilityUseCase verifyFileCompatibilityUseCase;

    public PersonResponse execute(String personId, MultipartFile image) throws PersonDoesNotExistsException, ProblemsToUploadImageException, FileIsNotCompatibleException {
        Optional<PersonDBDomain> personDBDomainOptional = findPersonByIdGateway.execute(personId);
        if (!personDBDomainOptional.isPresent()) throw new PersonDoesNotExistsException("Person does not exists");

        verifyFileCompatibilityUseCase.execute(image);

        String imgName = (personDBDomainOptional.get().getId() + "." + FilenameUtils.getExtension(image.getOriginalFilename()));
        try {
            Files.write(Paths.get((new File("public\\images\\user\\" + imgName).getAbsolutePath())), image.getBytes());
        } catch (Exception e) {
            throw new ProblemsToUploadImageException("Problem to upload the image");
        }
        personDBDomainOptional.get().setImage(imgName);

        return Translator.translate(updatePersonGateway.execute(Translator.translate(personDBDomainOptional.get(), Person.class)), PersonResponse.class);
    }
}
