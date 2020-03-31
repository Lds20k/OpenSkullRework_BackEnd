package com.teamrogerio.openskullrework.usecase;

import com.teamrogerio.openskullrework.controller.model.PersonResponse;
import com.teamrogerio.openskullrework.controller.translator.Translator;
import com.teamrogerio.openskullrework.gateway.mongodb.repository.GetAllPersonGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class GetAllPersonUseCase {

    private final GetAllPersonGateway getAllPersonGateway;

    public List<PersonResponse> execute(){
        return getAllPersonGateway.execute().stream().map(personDBDomain -> Translator.translate(personDBDomain, PersonResponse.class)).collect(Collectors.toList());
    }
}
