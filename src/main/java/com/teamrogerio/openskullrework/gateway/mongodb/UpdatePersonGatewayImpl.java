package com.teamrogerio.openskullrework.gateway.mongodb;

import com.teamrogerio.openskullrework.controller.translator.Translator;
import com.teamrogerio.openskullrework.entities.Person;
import com.teamrogerio.openskullrework.gateway.mongodb.model.PersonDBDomain;
import com.teamrogerio.openskullrework.gateway.mongodb.repository.PersonRepository;
import com.teamrogerio.openskullrework.gateway.mongodb.repository.UpdatePersonGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UpdatePersonGatewayImpl implements UpdatePersonGateway {

    private final PersonRepository personRepository;

    @Override
    public PersonDBDomain execute(Person person) {
        return personRepository.save(Translator.translate(person, PersonDBDomain.class));
    }
}
