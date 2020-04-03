package com.teamrogerio.openskullrework.gateway.mongodb;

import com.teamrogerio.openskullrework.controller.exception.PersonDoesNotExistsException;
import com.teamrogerio.openskullrework.gateway.mongodb.model.PersonDBDomain;
import com.teamrogerio.openskullrework.gateway.mongodb.repository.GetPersonByIdGateway;
import com.teamrogerio.openskullrework.gateway.mongodb.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class GetPersonByIdGatewayImpl implements GetPersonByIdGateway {

    private final PersonRepository personRepository;

    @Override
    public PersonDBDomain execute(String id) throws PersonDoesNotExistsException {
        Optional<PersonDBDomain> personDBDomain = personRepository.findById(id);
        if(!personDBDomain.isPresent()){
            throw new PersonDoesNotExistsException("Person does not exists");
        }
        return personDBDomain.get();
    }
}
