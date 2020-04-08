package com.teamrogerio.openskullrework.usecase;

import com.teamrogerio.openskullrework.controller.exception.CourseDoesNotExistsException;
import com.teamrogerio.openskullrework.controller.exception.CreatorCanNotSubscribeInYourOwnCourseException;
import com.teamrogerio.openskullrework.controller.exception.PersonDoesNotExistsException;
import com.teamrogerio.openskullrework.controller.model.EnrollmentResponse;
import com.teamrogerio.openskullrework.controller.translator.Translator;
import com.teamrogerio.openskullrework.entities.Course;
import com.teamrogerio.openskullrework.entities.Enrollment;
import com.teamrogerio.openskullrework.entities.Person;
import com.teamrogerio.openskullrework.gateway.mongodb.repository.AddCourseIntoPersonGateway;
import com.teamrogerio.openskullrework.gateway.mongodb.repository.GetCourseByIdGateway;
import com.teamrogerio.openskullrework.gateway.mongodb.repository.GetPersonByIdGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AddCourseIntoPersonUseCase {

    private final AddCourseIntoPersonGateway addCourseIntoPersonGateway;
    private final GetCourseByIdGateway getCourseByIdGateway;
    private final GetPersonByIdGateway getPersonByIdGateway;
    private final VerifyIfPersonIsCreatorOfCourseUseCase verifyIfPersonIsCreatorOfCourseUseCase;

    public EnrollmentResponse execute(String personId, String courseId) throws CourseDoesNotExistsException, PersonDoesNotExistsException, CreatorCanNotSubscribeInYourOwnCourseException {
        Course course = Translator.translate(getCourseByIdGateway.execute(courseId), Course.class);
        Person person = Translator.translate(getPersonByIdGateway.execute(personId), Person.class);
        verifyIfPersonIsCreatorOfCourseUseCase.execute(course, person);

        Enrollment enrollment = new Enrollment();
        enrollment.setCourse(course);
        enrollment.setPerson(person);
        return Translator.translate(addCourseIntoPersonGateway.execute(enrollment), EnrollmentResponse.class);
    }
}
