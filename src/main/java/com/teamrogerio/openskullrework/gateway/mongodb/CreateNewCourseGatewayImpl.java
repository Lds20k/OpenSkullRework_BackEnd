package com.teamrogerio.openskullrework.gateway.mongodb;

import com.teamrogerio.openskullrework.controller.translator.Translator;
import com.teamrogerio.openskullrework.entities.Course;
import com.teamrogerio.openskullrework.gateway.mongodb.model.CourseDBDomain;
import com.teamrogerio.openskullrework.gateway.mongodb.repository.CourseRepository;
import com.teamrogerio.openskullrework.gateway.mongodb.repository.CreateNewCourseGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CreateNewCourseGatewayImpl implements CreateNewCourseGateway {

    private final CourseRepository courseRepository;

    @Override
    public CourseDBDomain execute(Course course) {
        return courseRepository.save(Translator.translate(course, CourseDBDomain.class));
    }
}
