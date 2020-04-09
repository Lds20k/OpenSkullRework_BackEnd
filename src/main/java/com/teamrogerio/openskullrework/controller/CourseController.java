package com.teamrogerio.openskullrework.controller;

import com.teamrogerio.openskullrework.controller.exception.CourseDoesNotExistsException;
import com.teamrogerio.openskullrework.controller.exception.PersonDoesNotExistsException;
import com.teamrogerio.openskullrework.controller.model.CourseRequest;
import com.teamrogerio.openskullrework.controller.model.CourseResponse;
import com.teamrogerio.openskullrework.controller.translator.Translator;
import com.teamrogerio.openskullrework.entities.Course;
import com.teamrogerio.openskullrework.usecase.CreateNewCourseUseCase;
import com.teamrogerio.openskullrework.usecase.GetAllCoursesUseCase;
import com.teamrogerio.openskullrework.usecase.GetAllPersonCoursesUseCase;
import com.teamrogerio.openskullrework.usecase.GetCourseByIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Component
@RestController
@RequestMapping("/course")
public class CourseController {

    private final CreateNewCourseUseCase createNewCourseUseCase;
    private final GetAllCoursesUseCase getAllCoursesUseCase;
    private final GetCourseByIdUseCase getCourseByIdUseCase;
    private final GetAllPersonCoursesUseCase getAllPersonCoursesUseCase;

    //Insere
    @PostMapping
    public ResponseEntity<CourseResponse> postCourse(@RequestBody CourseRequest courseRequest) throws PersonDoesNotExistsException {
        return new ResponseEntity<>(createNewCourseUseCase.execute(Translator.translate(courseRequest, Course.class)), HttpStatus.OK);
    }

    //Get todos
    @GetMapping("/all/{page}")
    public ResponseEntity<List<CourseResponse>> getAllCourses(@PathVariable("page") int page){
        return new ResponseEntity<>(getAllCoursesUseCase.execute(page-1), HttpStatus.OK);
    }

    //Get um
    @GetMapping("/{id}")
    public ResponseEntity<CourseResponse> getCourseById(@PathVariable("id") String id) throws CourseDoesNotExistsException {
        return new ResponseEntity<>(getCourseByIdUseCase.execute(id), HttpStatus.OK);
    }

    //TODO: Deleta um

    //TODO: Atualizar

    @GetMapping("/person/{personId}")
    public ResponseEntity<List<CourseResponse>> getPersonCourse(@PathVariable("personId") String personId) throws PersonDoesNotExistsException {
        return new ResponseEntity<>(getAllPersonCoursesUseCase.execute(personId), HttpStatus.OK);
    }
}
