package com.teamrogerio.openskullrework.gateway.mongodb.repository;

import com.teamrogerio.openskullrework.gateway.mongodb.model.PersonDBDomain;

import java.util.List;

public interface GetAllPersonGateway {
    List<PersonDBDomain> execute();
}
