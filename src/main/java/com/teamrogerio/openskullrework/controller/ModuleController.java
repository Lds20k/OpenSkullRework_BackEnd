package com.teamrogerio.openskullrework.controller;

import com.teamrogerio.openskullrework.controller.exception.CourseDoesNotExistsException;
import com.teamrogerio.openskullrework.controller.model.ModuleRequest;
import com.teamrogerio.openskullrework.controller.model.ModuleResponse;
import com.teamrogerio.openskullrework.controller.translator.Translator;
import com.teamrogerio.openskullrework.entities.Module;
import com.teamrogerio.openskullrework.usecase.CreateNewModuleUseCase;
import com.teamrogerio.openskullrework.usecase.GetAllModulesUseCase;
import com.teamrogerio.openskullrework.usecase.GetCourseModulesUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Component
@RequestMapping("/module")
public class ModuleController {

    private final CreateNewModuleUseCase createNewModuleUseCase;
    private final GetAllModulesUseCase getAllModulesUseCase;
    private final GetCourseModulesUseCase getCourseModulesUseCase;

    @PostMapping
    public ResponseEntity<ModuleResponse> postModule(@RequestBody ModuleRequest moduleRequest) throws CourseDoesNotExistsException {
        return new ResponseEntity<>(createNewModuleUseCase.execute(Translator.translate(moduleRequest, Module.class)), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ModuleResponse>> getAllModules() {
        return new ResponseEntity<>(getAllModulesUseCase.execute(), HttpStatus.OK);
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<List<ModuleResponse>> getCourseModules(@PathVariable("courseId") String courseId) throws CourseDoesNotExistsException {
        return new ResponseEntity<>(getCourseModulesUseCase.execute(courseId), HttpStatus.OK);
    }
}
