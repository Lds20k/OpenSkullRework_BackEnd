package com.teamrogerio.openskullrework.gateway.mongodb.repository;

import com.teamrogerio.openskullrework.gateway.mongodb.model.CourseDBDomain;
import org.springframework.data.domain.Page;

import java.util.List;

public interface GetAllCoursesGateway {
    Page<CourseDBDomain> execute(int page);
}
