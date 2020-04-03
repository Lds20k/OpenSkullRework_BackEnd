package com.teamrogerio.openskullrework.usecase;

import com.teamrogerio.openskullrework.controller.exception.PersonDoesNotExistsException;
import com.teamrogerio.openskullrework.controller.model.PersonResponse;
import com.teamrogerio.openskullrework.controller.translator.Translator;
import com.teamrogerio.openskullrework.gateway.mongodb.repository.GetPersonByIdGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class GetPersonByIdUseCase {

    private final GetPersonByIdGateway getPersonByIdGateway;

    public PersonResponse execute(String id) throws PersonDoesNotExistsException {
        return Translator.translate(getPersonByIdGateway.execute(id), PersonResponse.class);
    }
}
