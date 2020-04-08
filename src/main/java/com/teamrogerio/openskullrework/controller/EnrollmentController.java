package com.teamrogerio.openskullrework.controller;

import com.teamrogerio.openskullrework.controller.exception.CourseDoesNotExistsException;
import com.teamrogerio.openskullrework.controller.exception.CreatorCanNotSubscribeInYourOwnCourseException;
import com.teamrogerio.openskullrework.controller.exception.PersonDoesNotExistsException;
import com.teamrogerio.openskullrework.controller.model.EnrollmentResponse;
import com.teamrogerio.openskullrework.usecase.AddCourseIntoPersonUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@Component
@RequestMapping("/enrollment")
public class EnrollmentController {

    private final AddCourseIntoPersonUseCase addCourseIntoPersonUseCase;

    //Adiciona um curso para o usuario
    @PostMapping("/{personId}/{courseId}")
    public ResponseEntity<EnrollmentResponse> postPersonCourse(@PathVariable("personId") String personId, @PathVariable("courseId") String courseId) throws CourseDoesNotExistsException, PersonDoesNotExistsException, CreatorCanNotSubscribeInYourOwnCourseException {
        return new ResponseEntity<>(addCourseIntoPersonUseCase.execute(personId, courseId), HttpStatus.OK);
    }
}
