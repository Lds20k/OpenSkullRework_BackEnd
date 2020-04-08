package com.teamrogerio.openskullrework.usecase;

import com.teamrogerio.openskullrework.controller.exception.EmailFormatIsNotValidException;
import com.teamrogerio.openskullrework.controller.exception.PersonAlreadyExistsException;
import com.teamrogerio.openskullrework.controller.exception.PersonDoesNotExistsException;
import com.teamrogerio.openskullrework.controller.model.PersonResponse;
import com.teamrogerio.openskullrework.controller.translator.Translator;
import com.teamrogerio.openskullrework.entities.Person;
import com.teamrogerio.openskullrework.gateway.mongodb.model.PersonDBDomain;
import com.teamrogerio.openskullrework.gateway.mongodb.repository.GetPersonByIdGateway;
import com.teamrogerio.openskullrework.gateway.mongodb.repository.UpdatePersonGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UpdatePersonUseCase {

    private final UpdatePersonGateway updatePersonGateway;
    private final GetPersonByIdGateway getPersonByIdGateway;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final VerifyIfEmailIsValidUseCase verifyIfEmailIsValidUseCase;
    private final VerifyIfEmailAlreadyExistsUseCase verifyIfEmailAlreadyExistsUseCase;

    public PersonResponse execute(Person person, String personId) throws PersonDoesNotExistsException, EmailFormatIsNotValidException, PersonAlreadyExistsException {
        PersonDBDomain personDBDomain = getPersonByIdGateway.execute(personId);

        Person updated = new Person();
        updated.setId(personId);
        updated.setName(person.getName() != null ? person.getName() : personDBDomain.getName());
        updated.setLastname(person.getLastname() != null ? person.getLastname() : personDBDomain.getLastname());
        updated.setPassword(person.getPassword() != null ? bCryptPasswordEncoder.encode(person.getPassword()) : personDBDomain.getPassword());
        updated.setBirth(person.getBirth() != null ? person.getBirth() : personDBDomain.getBirth());
        updated.setInstitution(person.getInstitution() != null ? person.getInstitution() : personDBDomain.getInstitution());
        updated.setImage(personDBDomain.getImage());
        updated.setBiography(person.getBiography() != null ? person.getBiography() : personDBDomain.getBiography());
        if (person.getEmail() != null) {
            verifyIfEmailIsValidUseCase.execute(person.getEmail());
            verifyIfEmailAlreadyExistsUseCase.execute(person.getEmail());
            updated.setEmail(person.getEmail());
        } else {
            updated.setEmail(personDBDomain.getEmail());
        }
        return Translator.translate(updatePersonGateway.execute(updated), PersonResponse.class);
    }
}
