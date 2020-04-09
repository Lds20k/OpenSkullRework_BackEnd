package com.teamrogerio.openskullrework.gateway.mongodb.repository;

import com.teamrogerio.openskullrework.entities.Module;
import com.teamrogerio.openskullrework.gateway.mongodb.model.ModuleDBDomain;

public interface CreateNewModuleGateway {
    ModuleDBDomain execute(Module module);
}
