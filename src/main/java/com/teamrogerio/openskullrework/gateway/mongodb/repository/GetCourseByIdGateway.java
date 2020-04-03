package com.teamrogerio.openskullrework.gateway.mongodb.repository;

import com.teamrogerio.openskullrework.controller.exception.CourseDoesNotExistsException;
import com.teamrogerio.openskullrework.gateway.mongodb.model.CourseDBDomain;

public interface GetCourseByIdGateway {
    CourseDBDomain execute(String id) throws CourseDoesNotExistsException;
}
