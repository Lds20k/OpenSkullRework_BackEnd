package com.teamrogerio.openskullrework.gateway.mongodb;

import com.teamrogerio.openskullrework.gateway.mongodb.model.PersonDBDomain;
import com.teamrogerio.openskullrework.gateway.mongodb.repository.GetAllPersonGateway;
import com.teamrogerio.openskullrework.gateway.mongodb.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class GetAllPersonGatewayImpl implements GetAllPersonGateway {

    private final PersonRepository personRepository;

    @Override
    public List<PersonDBDomain> execute() {
        return personRepository.findAll();
    }
}
