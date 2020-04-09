package com.teamrogerio.openskullrework.usecase;

import com.teamrogerio.openskullrework.controller.exception.CourseDoesNotExistsException;
import com.teamrogerio.openskullrework.controller.model.ModuleResponse;
import com.teamrogerio.openskullrework.controller.translator.Translator;
import com.teamrogerio.openskullrework.entities.Module;
import com.teamrogerio.openskullrework.gateway.mongodb.repository.CreateNewModuleGateway;
import com.teamrogerio.openskullrework.gateway.mongodb.repository.GetCourseByIdGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CreateNewModuleUseCase {

    private final CreateNewModuleGateway createNewModuleGateway;
    private final GetCourseByIdGateway getCourseByIdGateway;

    public ModuleResponse execute(Module module) throws CourseDoesNotExistsException {
        getCourseByIdGateway.execute(module.getCourse());
        return Translator.translate(createNewModuleGateway.execute(module), ModuleResponse.class);
    }
}
