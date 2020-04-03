package com.teamrogerio.openskullrework.gateway.mongodb.repository;

import com.teamrogerio.openskullrework.controller.exception.PersonDoesNotExistsException;
import com.teamrogerio.openskullrework.gateway.mongodb.model.PersonDBDomain;

public interface GetPersonByIdGateway {
    PersonDBDomain execute(String id) throws PersonDoesNotExistsException;
}
