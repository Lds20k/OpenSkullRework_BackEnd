package com.teamrogerio.openskullrework.controller;

import com.teamrogerio.openskullrework.controller.model.CourseRequest;
import com.teamrogerio.openskullrework.controller.model.CourseResponse;
import com.teamrogerio.openskullrework.controller.translator.Translator;
import com.teamrogerio.openskullrework.entities.Course;
import com.teamrogerio.openskullrework.usecase.CreateNewCourseUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Component
@RestController
@RequestMapping("/course")
public class CourseController {

    private final CreateNewCourseUseCase createNewCourseUseCase;

    @PostMapping
    public ResponseEntity<CourseResponse> postCourse(@RequestBody CourseRequest courseRequest){
        return new ResponseEntity<>(createNewCourseUseCase.execute(Translator.translate(courseRequest, Course.class)), HttpStatus.OK);
    }
}
