package com.teamrogerio.openskullrework.usecase;

import com.teamrogerio.openskullrework.controller.exception.PersonDoesNotExistsException;
import com.teamrogerio.openskullrework.controller.model.CourseResponse;
import com.teamrogerio.openskullrework.controller.translator.Translator;
import com.teamrogerio.openskullrework.entities.Person;
import com.teamrogerio.openskullrework.gateway.mongodb.repository.GetAllPersonCoursesGateway;
import com.teamrogerio.openskullrework.gateway.mongodb.repository.GetPersonByIdGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class GetAllPersonCoursesUseCase {

    private final GetAllPersonCoursesGateway getAllPersonCoursesGateway;
    private final GetPersonByIdGateway getPersonByIdGateway;

    public List<CourseResponse> execute(String personId) throws PersonDoesNotExistsException {
        Person person = Translator.translate(getPersonByIdGateway.execute(personId), Person.class);
        return getAllPersonCoursesGateway.execute(person).stream().map(courseDBDomain -> Translator.translate(courseDBDomain, CourseResponse.class)).collect(Collectors.toList());
    }
}
