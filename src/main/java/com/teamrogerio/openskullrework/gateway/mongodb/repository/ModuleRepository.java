package com.teamrogerio.openskullrework.gateway.mongodb.repository;

import com.teamrogerio.openskullrework.gateway.mongodb.model.ModuleDBDomain;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ModuleRepository extends MongoRepository<ModuleDBDomain, String> {
    List<ModuleDBDomain> findAllModuleByCourse(String course);
}
