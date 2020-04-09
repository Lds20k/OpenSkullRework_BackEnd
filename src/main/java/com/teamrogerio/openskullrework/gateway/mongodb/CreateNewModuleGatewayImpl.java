package com.teamrogerio.openskullrework.gateway.mongodb;

import com.teamrogerio.openskullrework.controller.translator.Translator;
import com.teamrogerio.openskullrework.entities.Module;
import com.teamrogerio.openskullrework.gateway.mongodb.model.ModuleDBDomain;
import com.teamrogerio.openskullrework.gateway.mongodb.repository.CreateNewModuleGateway;
import com.teamrogerio.openskullrework.gateway.mongodb.repository.ModuleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CreateNewModuleGatewayImpl implements CreateNewModuleGateway {

    private final ModuleRepository moduleRepository;

    @Override
    public ModuleDBDomain execute(Module module) {
        return moduleRepository.save(Translator.translate(module, ModuleDBDomain.class));
    }
}
