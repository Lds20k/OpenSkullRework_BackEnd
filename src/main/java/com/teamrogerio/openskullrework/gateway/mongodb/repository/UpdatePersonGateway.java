package com.teamrogerio.openskullrework.gateway.mongodb.repository;

import com.teamrogerio.openskullrework.entities.Person;
import com.teamrogerio.openskullrework.gateway.mongodb.model.PersonDBDomain;

public interface UpdatePersonGateway {
    PersonDBDomain execute(Person person);
}
