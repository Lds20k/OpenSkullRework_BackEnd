package com.teamrogerio.openskullrework.usecase;

import com.teamrogerio.openskullrework.controller.exception.EmailFormatIsNotValidException;
import com.teamrogerio.openskullrework.controller.exception.PersonAlreadyExistsException;
import com.teamrogerio.openskullrework.controller.exception.PersonDoesNotExistsException;
import com.teamrogerio.openskullrework.controller.model.PersonResponse;
import com.teamrogerio.openskullrework.controller.translator.Translator;
import com.teamrogerio.openskullrework.entities.Person;
import com.teamrogerio.openskullrework.gateway.mongodb.model.PersonDBDomain;
import com.teamrogerio.openskullrework.gateway.mongodb.repository.FindPersonByIdGateway;
import com.teamrogerio.openskullrework.gateway.mongodb.repository.UpdatePersonGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class UpdatePersonUseCase {

    private final UpdatePersonGateway updatePersonGateway;
    private final FindPersonByIdGateway findPersonByIdGateway;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final VerifyIfEmailIsValidUseCase verifyIfEmailIsValidUseCase;
    private final VerifyIfPersonAlreadyExistsByEmailUseCase verifyIfPersonAlreadyExistsByEmailUseCase;

    public PersonResponse execute(Person person, String personId) throws PersonDoesNotExistsException, EmailFormatIsNotValidException, PersonAlreadyExistsException {
        Optional<PersonDBDomain> personDBDomainOptional = findPersonByIdGateway.execute(personId);
        if (!personDBDomainOptional.isPresent()) throw new PersonDoesNotExistsException("Person does not exists");

        Person updated = new Person();
        updated.setId(personId);
        updated.setName(person.getName() != null ? person.getName() : personDBDomainOptional.get().getName());
        updated.setLastname(person.getLastname() != null ? person.getLastname() : personDBDomainOptional.get().getLastname());
        updated.setPassword(person.getPassword() != null ? bCryptPasswordEncoder.encode(person.getPassword()) : personDBDomainOptional.get().getPassword());
        updated.setBirth(person.getBirth() != null ? person.getBirth() : personDBDomainOptional.get().getBirth());
        updated.setInstitution(person.getInstitution() != null ? person.getInstitution() : personDBDomainOptional.get().getInstitution());
        updated.setImage(personDBDomainOptional.get().getImage());
        updated.setBiography(person.getBiography() != null ? person.getBiography() : personDBDomainOptional.get().getBiography());
        updated.setCourses(personDBDomainOptional.get().getCourses());
        updated.setCreatedAt(personDBDomainOptional.get().getCreatedAt());
        if (person.getEmail() != null) {
            verifyIfEmailIsValidUseCase.execute(person.getEmail());
            verifyIfPersonAlreadyExistsByEmailUseCase.execute(person.getEmail());
            updated.setEmail(person.getEmail());
        } else {
            updated.setEmail(personDBDomainOptional.get().getEmail());
        }
        return Translator.translate(updatePersonGateway.execute(updated), PersonResponse.class);
    }
}
