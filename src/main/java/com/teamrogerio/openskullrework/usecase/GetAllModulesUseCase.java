package com.teamrogerio.openskullrework.usecase;

import com.teamrogerio.openskullrework.controller.model.ModuleResponse;
import com.teamrogerio.openskullrework.controller.translator.Translator;
import com.teamrogerio.openskullrework.gateway.mongodb.repository.GetAllModulesGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class GetAllModulesUseCase {

    private final GetAllModulesGateway getAllModulesGateway;

    public List<ModuleResponse> execute() {
        return getAllModulesGateway.execute().stream().map(moduleDBDomain -> Translator.translate(moduleDBDomain, ModuleResponse.class)).collect(Collectors.toList());
    }
}
