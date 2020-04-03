package com.teamrogerio.openskullrework.usecase;

import com.teamrogerio.openskullrework.controller.exception.EmailFormatIsNotValidException;
import lombok.RequiredArgsConstructor;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VerifyIfEmailIsValidUseCase {

    public void execute(String email) throws EmailFormatIsNotValidException {
        if(!EmailValidator.getInstance().isValid(email)){
            throw new EmailFormatIsNotValidException("The email format is not valid");
        }
    }
}