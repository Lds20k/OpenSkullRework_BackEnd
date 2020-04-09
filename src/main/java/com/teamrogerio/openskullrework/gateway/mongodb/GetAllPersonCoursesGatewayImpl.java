package com.teamrogerio.openskullrework.gateway.mongodb;

import com.teamrogerio.openskullrework.entities.Person;
import com.teamrogerio.openskullrework.gateway.mongodb.model.CourseDBDomain;
import com.teamrogerio.openskullrework.gateway.mongodb.repository.CourseRepository;
import com.teamrogerio.openskullrework.gateway.mongodb.repository.GetAllPersonCoursesGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class GetAllPersonCoursesGatewayImpl implements GetAllPersonCoursesGateway {

    private final CourseRepository courseRepository;

    @Override
    public List<CourseDBDomain> execute(Person person) {
        return courseRepository.findAllCourseByCreator(person.getId());
    }
}
