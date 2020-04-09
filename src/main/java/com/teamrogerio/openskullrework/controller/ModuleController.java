package com.teamrogerio.openskullrework.controller;

import com.teamrogerio.openskullrework.controller.exception.CourseDoesNotExistsException;
import com.teamrogerio.openskullrework.controller.model.ModuleRequest;
import com.teamrogerio.openskullrework.controller.model.ModuleResponse;
import com.teamrogerio.openskullrework.controller.translator.Translator;
import com.teamrogerio.openskullrework.entities.Module;
import com.teamrogerio.openskullrework.usecase.CreateNewModuleUseCase;
import com.teamrogerio.openskullrework.usecase.GetAllModulesUseCase;
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

    @PostMapping
    public ResponseEntity<ModuleResponse> postCourse(@RequestBody ModuleRequest moduleRequest) throws CourseDoesNotExistsException {
        return new ResponseEntity<>(createNewModuleUseCase.execute(Translator.translate(moduleRequest, Module.class)), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ModuleResponse>> getAllCourses() {
        return new ResponseEntity<>(getAllModulesUseCase.execute(), HttpStatus.OK);
    }
}
