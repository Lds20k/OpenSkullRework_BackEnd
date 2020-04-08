package com.teamrogerio.openskullrework.usecase;

import com.teamrogerio.openskullrework.controller.exception.CreatorCanNotSubscribeInYourOwnCourseException;
import com.teamrogerio.openskullrework.entities.Course;
import com.teamrogerio.openskullrework.entities.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class VerifyIfPersonIsCreatorOfCourseUseCase {

    public void execute(Course course, Person person) throws CreatorCanNotSubscribeInYourOwnCourseException {
        if (person.getId().equals(course.getCreator())) {
            throw new CreatorCanNotSubscribeInYourOwnCourseException("Creator can't subscribe in your own course");
        }
    }
}
