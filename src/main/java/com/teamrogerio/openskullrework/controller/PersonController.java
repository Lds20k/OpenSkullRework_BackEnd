package com.teamrogerio.openskullrework.controller;

import com.teamrogerio.openskullrework.controller.model.PersonRequest;
import com.teamrogerio.openskullrework.controller.model.PersonResponse;
import com.teamrogerio.openskullrework.controller.translator.Translator;
import com.teamrogerio.openskullrework.entities.Person;
import com.teamrogerio.openskullrework.usecase.CreateNewPersonUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@Component
@RequestMapping("/person")
public class PersonController {

    private final CreateNewPersonUseCase createNewPersonUseCase;

    @PostMapping
    public ResponseEntity<PersonResponse> postPerson(@RequestBody PersonRequest request){
        return new ResponseEntity<>(createNewPersonUseCase.execute(Translator.translate(request, Person.class)), HttpStatus.OK);
    }
}
