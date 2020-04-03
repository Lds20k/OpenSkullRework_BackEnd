package com.teamrogerio.openskullrework.usecase;

import com.teamrogerio.openskullrework.controller.exception.PersonAlreadyHaveCourseException;
import com.teamrogerio.openskullrework.entities.PersonCourse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.List;

@RequiredArgsConstructor
@Component
public class VerifyPersonHaveCourseUseCase {

    public void execute(List<PersonCourse> personCourses, PersonCourse personCourse) throws PersonAlreadyHaveCourseException {
        Iterator it = personCourses.iterator();
        while (it.hasNext()){
            PersonCourse course = (PersonCourse) it.next();
            if(course.getId().equals(personCourse.getId())){
                throw new PersonAlreadyHaveCourseException("Person already have this course");
            }
        }
    }
}
