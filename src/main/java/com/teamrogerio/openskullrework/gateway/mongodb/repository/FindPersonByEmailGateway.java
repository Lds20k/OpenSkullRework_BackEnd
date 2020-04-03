package com.teamrogerio.openskullrework.gateway.mongodb.repository;

import com.teamrogerio.openskullrework.gateway.mongodb.model.PersonDBDomain;

import java.util.Optional;

public interface FindPersonByEmailGateway {
    Optional<PersonDBDomain> execute(String email);
}
