package com.teamrogerio.openskullrework.usecase;

import com.teamrogerio.openskullrework.controller.exception.CourseDoesNotExistsException;
import com.teamrogerio.openskullrework.controller.model.ModuleResponse;
import com.teamrogerio.openskullrework.controller.translator.Translator;
import com.teamrogerio.openskullrework.entities.Course;
import com.teamrogerio.openskullrework.gateway.mongodb.repository.GetCourseByIdGateway;
import com.teamrogerio.openskullrework.gateway.mongodb.repository.GetCourseModulesGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class GetCourseModulesUseCase {

    private final GetCourseModulesGateway getCourseModulesGateway;
    private final GetCourseByIdGateway getCourseByIdGateway;

    public List<ModuleResponse> execute(String courseId) throws CourseDoesNotExistsException {
        Course course = Translator.translate(getCourseByIdGateway.execute(courseId), Course.class);
        return getCourseModulesGateway.execute(course).stream().map(moduleDBDomain -> Translator.translate(moduleDBDomain, ModuleResponse.class)).collect(Collectors.toList());
    }
}