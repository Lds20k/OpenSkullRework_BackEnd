package com.teamrogerio.openskullrework.usecase;

import com.teamrogerio.openskullrework.controller.exception.PersonDoesNotExistsException;
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
    private final VerifyIfPersonExistsUseCase verifyIfPersonExistsUseCase;

    public CourseResponse execute(Course course) throws PersonDoesNotExistsException {
        if(!verifyIfPersonExistsUseCase.execute(course.getCreator())){
            throw new PersonDoesNotExistsException("Creator does not exists");
        }
        return Translator.translate(createNewCourseGateway.execute(course), CourseResponse.class);
    }
}
