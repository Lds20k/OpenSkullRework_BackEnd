package com.teamrogerio.openskullrework.gateway.mongodb;

import com.teamrogerio.openskullrework.gateway.mongodb.model.ModuleDBDomain;
import com.teamrogerio.openskullrework.gateway.mongodb.repository.GetAllModulesGateway;
import com.teamrogerio.openskullrework.gateway.mongodb.repository.ModuleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class GetAllModulesGatewayImpl implements GetAllModulesGateway {

    private final ModuleRepository moduleRepository;

    @Override
    public List<ModuleDBDomain> execute() {
        return moduleRepository.findAll();
    }
}
