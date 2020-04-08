package com.teamrogerio.openskullrework.usecase;

import com.teamrogerio.openskullrework.controller.exception.PersonAlreadyExistsException;
import com.teamrogerio.openskullrework.gateway.mongodb.model.PersonDBDomain;
import com.teamrogerio.openskullrework.gateway.mongodb.repository.FindPersonByEmailGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class VerifyIfEmailAlreadyExistsUseCase {

    private final FindPersonByEmailGateway findPersonByEmailGateway;

    public void execute(String email) throws PersonAlreadyExistsException {
        Optional<PersonDBDomain> personDBDomain = findPersonByEmailGateway.execute(email);
        if (personDBDomain.isPresent()) {
            throw new PersonAlreadyExistsException("This email has already been registered");
        }
    }
}
