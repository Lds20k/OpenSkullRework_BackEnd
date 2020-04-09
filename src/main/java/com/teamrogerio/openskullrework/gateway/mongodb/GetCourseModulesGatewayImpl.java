package com.teamrogerio.openskullrework.gateway.mongodb;

import com.teamrogerio.openskullrework.entities.Course;
import com.teamrogerio.openskullrework.gateway.mongodb.model.ModuleDBDomain;
import com.teamrogerio.openskullrework.gateway.mongodb.repository.GetCourseModulesGateway;
import com.teamrogerio.openskullrework.gateway.mongodb.repository.ModuleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class GetCourseModulesGatewayImpl implements GetCourseModulesGateway {

    private final ModuleRepository moduleRepository;

    @Override
    public List<ModuleDBDomain> execute(Course course) {
        return moduleRepository.findAllModuleByCourse(course.getId());
    }
}
