package com.teamrogerio.openskullrework.usecase;

import com.teamrogerio.openskullrework.controller.exception.CourseDoesNotExistsException;
import com.teamrogerio.openskullrework.controller.exception.PersonAlreadyHaveCourseException;
import com.teamrogerio.openskullrework.controller.exception.PersonDoesNotExistsException;
import com.teamrogerio.openskullrework.controller.model.PersonResponse;
import com.teamrogerio.openskullrework.controller.translator.Translator;
import com.teamrogerio.openskullrework.gateway.mongodb.repository.AddCourseIntoPersonGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AddCourseIntoPersonUseCase {

    private final AddCourseIntoPersonGateway addCourseIntoPersonGateway;

    public PersonResponse execute(String personId, String courseId) throws PersonAlreadyHaveCourseException, PersonDoesNotExistsException, CourseDoesNotExistsException {
        return Translator.translate(addCourseIntoPersonGateway.execute(personId, courseId), PersonResponse.class);
    }
}
