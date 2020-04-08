package com.teamrogerio.openskullrework.gateway.mongodb.repository;

import com.teamrogerio.openskullrework.gateway.mongodb.model.EnrollmentDBDomain;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EnrollmentRespository extends MongoRepository<EnrollmentDBDomain, String> {
}
