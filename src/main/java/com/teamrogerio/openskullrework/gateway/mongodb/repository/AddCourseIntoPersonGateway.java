package com.teamrogerio.openskullrework.gateway.mongodb.repository;

import com.teamrogerio.openskullrework.controller.exception.CourseDoesNotExistsException;
import com.teamrogerio.openskullrework.controller.exception.PersonDoesNotExistsException;
import com.teamrogerio.openskullrework.entities.Enrollment;
import com.teamrogerio.openskullrework.gateway.mongodb.model.EnrollmentDBDomain;

public interface AddCourseIntoPersonGateway {
    EnrollmentDBDomain execute(Enrollment enrollment) throws CourseDoesNotExistsException, PersonDoesNotExistsException;
}
