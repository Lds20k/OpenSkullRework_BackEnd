package com.teamrogerio.openskullrework.gateway.mongodb.repository;

import com.teamrogerio.openskullrework.entities.Course;
import com.teamrogerio.openskullrework.gateway.mongodb.model.ModuleDBDomain;

import java.util.List;

public interface GetCourseModulesGateway {
    List<ModuleDBDomain> execute(Course course);
}
