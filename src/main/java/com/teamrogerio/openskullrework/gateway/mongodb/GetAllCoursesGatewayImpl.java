package com.teamrogerio.openskullrework.gateway.mongodb;

import com.teamrogerio.openskullrework.gateway.mongodb.model.CourseDBDomain;
import com.teamrogerio.openskullrework.gateway.mongodb.repository.CourseRepository;
import com.teamrogerio.openskullrework.gateway.mongodb.repository.GetAllCoursesGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class GetAllCoursesGatewayImpl implements GetAllCoursesGateway {

    private final CourseRepository courseRepository;
    @Override
    public Page<CourseDBDomain> execute(int page) {
        return courseRepository.findAll(PageRequest.of(page, 10 , Sort.unsorted()));
    }
}
