package com.teamrogerio.openskullrework.controller;

import com.teamrogerio.openskullrework.controller.exception.*;
import com.teamrogerio.openskullrework.controller.model.PersonRequest;
import com.teamrogerio.openskullrework.controller.model.PersonResponse;
import com.teamrogerio.openskullrework.controller.translator.Translator;
import com.teamrogerio.openskullrework.entities.Person;
import com.teamrogerio.openskullrework.usecase.AddCourseIntoPersonUseCase;
import com.teamrogerio.openskullrework.usecase.CreateNewPersonUseCase;
import com.teamrogerio.openskullrework.usecase.GetAllPersonUseCase;
import com.teamrogerio.openskullrework.usecase.GetPersonByIdUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Component
@RequestMapping("/person")
public class PersonController {

    private final CreateNewPersonUseCase createNewPersonUseCase;
    private final GetAllPersonUseCase getAllPersonUseCase;
    private final AddCourseIntoPersonUseCase addCourseIntoPersonUseCase;
    private final GetPersonByIdUseCase getPersonByIdUseCase;

    //Insere
    @PostMapping
    public ResponseEntity<PersonResponse> postPerson(@RequestBody PersonRequest request) throws EmailFormatIsNotValidException, PersonAlreadyExistsException {
        return new ResponseEntity<>(createNewPersonUseCase.execute(Translator.translate(request, Person.class)), HttpStatus.OK);
    }

    //Get todos
    @GetMapping
    public ResponseEntity<List<PersonResponse>> getAllPerson(){
        return new ResponseEntity<>(getAllPersonUseCase.execute(), HttpStatus.OK);
    }

    //Get um
    @GetMapping("/{personId}")
    public ResponseEntity<PersonResponse> getPersonById(@PathVariable("personId") String personId) throws PersonDoesNotExistsException {
        return new ResponseEntity<>(getPersonByIdUseCase.execute(personId), HttpStatus.OK);
    }

    //TODO: Deleta um

    //TODO: Retorna um jwt para login

    //TODO: Atualizar

    //Adiciona um curso para o usuario
    @PostMapping("/{personId}/{courseId}")
    public ResponseEntity<PersonResponse> postPersonCourse(@PathVariable("personId") String personId, @PathVariable("courseId") String courseId) throws PersonAlreadyHaveCourseException, CourseDoesNotExistsException, PersonDoesNotExistsException {
        return new ResponseEntity<>(addCourseIntoPersonUseCase.execute(personId, courseId), HttpStatus.OK);
    }
}
