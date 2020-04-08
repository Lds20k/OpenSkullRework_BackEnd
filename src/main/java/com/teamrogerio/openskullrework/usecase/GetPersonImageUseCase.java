package com.teamrogerio.openskullrework.usecase;

import com.teamrogerio.openskullrework.controller.exception.PersonDoesNotExistsException;
import com.teamrogerio.openskullrework.controller.model.ImageResponse;
import com.teamrogerio.openskullrework.gateway.mongodb.model.PersonDBDomain;
import com.teamrogerio.openskullrework.gateway.mongodb.repository.GetPersonByIdGateway;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

@RequiredArgsConstructor
@Component
public class GetPersonImageUseCase {

    private final GetPersonByIdGateway getPersonByIdGateway;

    public ImageResponse execute(String personId) throws PersonDoesNotExistsException, IOException {
        PersonDBDomain personDBDomain = getPersonByIdGateway.execute(personId);
        File file;
        if (personDBDomain.getImage() != null) {
            file = new File(new File("public\\images\\user\\" + personDBDomain.getImage()).getAbsolutePath());
        } else {
            file = new File(new File("public\\images\\user\\default.png").getAbsolutePath());
        }

        byte[] bytes = new byte[(int) file.length()];
        new FileInputStream(file).read(bytes);
        return new ImageResponse(new String(Base64.encodeBase64(bytes)));
    }
}
