package com.teamrogerio.openskullrework.gateway.mongodb.repository;

import com.teamrogerio.openskullrework.gateway.mongodb.model.CourseDBDomain;
import com.teamrogerio.openskullrework.gateway.mongodb.model.PersonDBDomain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface PersonRepository extends MongoRepository<PersonDBDomain, String> {
    Optional<PersonDBDomain> findPersonByEmail(String email);
}
