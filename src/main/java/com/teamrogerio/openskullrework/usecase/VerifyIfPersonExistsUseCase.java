package com.teamrogerio.openskullrework.usecase;

import com.teamrogerio.openskullrework.gateway.mongodb.model.PersonDBDomain;
import com.teamrogerio.openskullrework.gateway.mongodb.repository.FindPersonByIdGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class VerifyIfPersonExistsUseCase {

    private final FindPersonByIdGateway findPersonByIdGateway;

    public boolean execute(String id){
        Optional<PersonDBDomain> personDBDomain = findPersonByIdGateway.execute(id);
        if(personDBDomain.isPresent()){
            return true;
        }else{
            return false;
        }
    }
}
