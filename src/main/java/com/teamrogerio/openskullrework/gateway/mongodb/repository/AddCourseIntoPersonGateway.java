package com.teamrogerio.openskullrework.gateway.mongodb.repository;

import com.teamrogerio.openskullrework.controller.exception.CourseDoesNotExistsException;
import com.teamrogerio.openskullrework.controller.exception.PersonAlreadyHaveCourseException;
import com.teamrogerio.openskullrework.controller.exception.PersonDoesNotExistsException;
import com.teamrogerio.openskullrework.gateway.mongodb.model.PersonDBDomain;

public interface AddCourseIntoPersonGateway {
    PersonDBDomain execute(String personId, String courseId) throws PersonAlreadyHaveCourseException, CourseDoesNotExistsException, PersonDoesNotExistsException;
}
