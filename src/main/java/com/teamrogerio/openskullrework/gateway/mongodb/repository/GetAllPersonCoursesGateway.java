package com.teamrogerio.openskullrework.gateway.mongodb.repository;

import com.teamrogerio.openskullrework.entities.Person;
import com.teamrogerio.openskullrework.gateway.mongodb.model.CourseDBDomain;

import java.util.List;

public interface GetAllPersonCoursesGateway {
    List<CourseDBDomain> execute(Person person);
}
