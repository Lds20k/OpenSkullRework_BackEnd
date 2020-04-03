package com.teamrogerio.openskullrework.gateway.mongodb;

import com.teamrogerio.openskullrework.gateway.mongodb.model.PersonDBDomain;
import com.teamrogerio.openskullrework.gateway.mongodb.repository.FindPersonByEmailGateway;
import com.teamrogerio.openskullrework.gateway.mongodb.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class FindPersonByEmailGatewayImpl implements FindPersonByEmailGateway {

    private final PersonRepository personRepository;

    @Override
    public Optional<PersonDBDomain> execute(String email) {
        return personRepository.findPersonByEmail(email);
    }
}
