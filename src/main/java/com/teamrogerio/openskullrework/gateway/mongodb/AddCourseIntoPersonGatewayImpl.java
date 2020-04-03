package com.teamrogerio.openskullrework.gateway.mongodb;

import com.teamrogerio.openskullrework.controller.exception.CourseDoesNotExistsException;
import com.teamrogerio.openskullrework.controller.exception.PersonAlreadyHaveCourseException;
import com.teamrogerio.openskullrework.controller.exception.PersonDoesNotExistsException;
import com.teamrogerio.openskullrework.controller.translator.Translator;
import com.teamrogerio.openskullrework.entities.Person;
import com.teamrogerio.openskullrework.entities.PersonCourse;
import com.teamrogerio.openskullrework.gateway.mongodb.model.CourseDBDomain;
import com.teamrogerio.openskullrework.gateway.mongodb.model.PersonDBDomain;
import com.teamrogerio.openskullrework.gateway.mongodb.repository.AddCourseIntoPersonGateway;
import com.teamrogerio.openskullrework.gateway.mongodb.repository.CourseRepository;
import com.teamrogerio.openskullrework.gateway.mongodb.repository.PersonRepository;
import com.teamrogerio.openskullrework.usecase.VerifyPersonHaveCourseUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class AddCourseIntoPersonGatewayImpl implements AddCourseIntoPersonGateway {

    private final PersonRepository personRepository;
    private final CourseRepository courseRepository;
    private final VerifyPersonHaveCourseUseCase verifyPersonHaveCourseUseCase;

    @Override
    public PersonDBDomain execute(String personId, String courseId) throws PersonAlreadyHaveCourseException, CourseDoesNotExistsException, PersonDoesNotExistsException {
        Optional<CourseDBDomain> courseDBDomain = courseRepository.findById(courseId);
        if(!courseDBDomain.isPresent()){
            throw new CourseDoesNotExistsException("Course does not exists");
        }
        PersonCourse personCourse = Translator.translate(courseDBDomain.get(), PersonCourse.class);

        Optional<PersonDBDomain> personDBDomain = personRepository.findById(personId);
        if(!personDBDomain.isPresent()){
            throw new PersonDoesNotExistsException("Person does not exists");
        }
        Person person = Translator.translate(personDBDomain.get(), Person.class);

        List<PersonCourse> courseList = person.getCourses();
        if(courseList == null) courseList = new ArrayList();
        verifyPersonHaveCourseUseCase.execute(courseList, personCourse);
        courseList.add(personCourse);
        person.setCourses(courseList);
        return personRepository.save(Translator.translate(person, PersonDBDomain.class));
    }
}
