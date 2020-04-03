package com.teamrogerio.openskullrework.gateway.mongodb;

import com.teamrogerio.openskullrework.controller.translator.Translator;
import com.teamrogerio.openskullrework.entities.Person;
import com.teamrogerio.openskullrework.gateway.mongodb.model.PersonDBDomain;
import com.teamrogerio.openskullrework.gateway.mongodb.repository.CreateNewPersonGateway;
import com.teamrogerio.openskullrework.gateway.mongodb.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CreateNewPersonGatewayImpl implements CreateNewPersonGateway {

    private final PersonRepository personRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public PersonDBDomain execute(Person person) {
        person.setPassword(bCryptPasswordEncoder.encode(person.getPassword()));
        return personRepository.save(Translator.translate(person, PersonDBDomain.class));
    }
}
