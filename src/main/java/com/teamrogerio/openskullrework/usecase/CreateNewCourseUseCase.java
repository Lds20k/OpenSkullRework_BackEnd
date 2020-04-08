package com.teamrogerio.openskullrework.usecase;

import com.teamrogerio.openskullrework.controller.exception.PersonDoesNotExistsException;
import com.teamrogerio.openskullrework.controller.model.CourseResponse;
import com.teamrogerio.openskullrework.controller.translator.Translator;
import com.teamrogerio.openskullrework.entities.Course;
import com.teamrogerio.openskullrework.gateway.mongodb.repository.CreateNewCourseGateway;
import com.teamrogerio.openskullrework.gateway.mongodb.repository.GetPersonByIdGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CreateNewCourseUseCase {

    private final CreateNewCourseGateway createNewCourseGateway;
    private final GetPersonByIdGateway getPersonByIdGateway;

    public CourseResponse execute(Course course) throws PersonDoesNotExistsException {
        getPersonByIdGateway.execute(course.getCreator());
        return Translator.translate(createNewCourseGateway.execute(course), CourseResponse.class);
    }
}
