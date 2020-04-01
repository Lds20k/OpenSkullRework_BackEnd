package com.teamrogerio.openskullrework.usecase;

import com.teamrogerio.openskullrework.controller.model.CourseResponse;
import com.teamrogerio.openskullrework.controller.translator.Translator;
import com.teamrogerio.openskullrework.entities.Course;
import com.teamrogerio.openskullrework.gateway.mongodb.repository.CreateNewCourseGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CreateNewCourseUseCase {

    private final CreateNewCourseGateway createNewCourseGateway;

    public CourseResponse execute(Course course){
        return Translator.translate(createNewCourseGateway.execute(course), CourseResponse.class);
    }
}
