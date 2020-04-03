package com.teamrogerio.openskullrework.gateway.mongodb;

import com.teamrogerio.openskullrework.gateway.mongodb.model.PersonDBDomain;
import com.teamrogerio.openskullrework.gateway.mongodb.repository.FindPersonByIdGateway;
import com.teamrogerio.openskullrework.gateway.mongodb.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class FindPersonByIdGatewayImpl implements FindPersonByIdGateway {

    private final PersonRepository personRepository;

    @Override
    public Optional<PersonDBDomain> execute(String id) {
        return personRepository.findById(id);
    }
}
