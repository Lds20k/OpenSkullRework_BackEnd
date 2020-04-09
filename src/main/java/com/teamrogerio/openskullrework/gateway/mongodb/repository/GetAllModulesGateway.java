package com.teamrogerio.openskullrework.gateway.mongodb.repository;

import com.teamrogerio.openskullrework.gateway.mongodb.model.ModuleDBDomain;

import java.util.List;

public interface GetAllModulesGateway {
    List<ModuleDBDomain> execute();
}
