package com.teamrogerio.openskullrework.gateway.mongodb.repository;

import com.teamrogerio.openskullrework.entities.Course;
import com.teamrogerio.openskullrework.gateway.mongodb.model.CourseDBDomain;

public interface CreateNewCourseGateway {
    CourseDBDomain execute(Course course);
}
