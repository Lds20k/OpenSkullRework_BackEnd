package com.teamrogerio.openskullrework.gateway.mongodb;

import com.teamrogerio.openskullrework.controller.exception.CourseDoesNotExistsException;
import com.teamrogerio.openskullrework.gateway.mongodb.model.CourseDBDomain;
import com.teamrogerio.openskullrework.gateway.mongodb.repository.CourseRepository;
import com.teamrogerio.openskullrework.gateway.mongodb.repository.GetCourseByIdGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class GetCourseByIdGatewayImpl implements GetCourseByIdGateway {

    private final CourseRepository courseRepository;

    @Override
    public CourseDBDomain execute(String id) throws CourseDoesNotExistsException {
        Optional<CourseDBDomain> course = courseRepository.findById(id);
        if(!course.isPresent()){
            throw new CourseDoesNotExistsException("Course does not exists");
        }
        return course.get();
    }
}
