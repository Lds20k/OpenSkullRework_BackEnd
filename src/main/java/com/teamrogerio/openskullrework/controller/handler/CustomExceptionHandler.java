package com.teamrogerio.openskullrework.controller.handler;

import com.teamrogerio.openskullrework.controller.exception.CourseDoesNotExistsException;
import com.teamrogerio.openskullrework.controller.exception.PersonAlreadyExistsException;
import com.teamrogerio.openskullrework.controller.exception.PersonAlreadyHaveCourseException;
import com.teamrogerio.openskullrework.controller.exception.PersonDoesNotExistsException;
import com.teamrogerio.openskullrework.controller.model.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler({PersonAlreadyHaveCourseException.class})
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handlePersonAlreadyHaveCourseException(final PersonAlreadyHaveCourseException e) {
        return new ErrorResponse(e.getMessage());
    }

    @ExceptionHandler({PersonDoesNotExistsException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handlePersonDoesNotExists(final PersonDoesNotExistsException e) {
        return new ErrorResponse(e.getMessage());
    }

    @ExceptionHandler({CourseDoesNotExistsException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleCourseDoesNotExists(final CourseDoesNotExistsException e) {
        return new ErrorResponse(e.getMessage());
    }

    @ExceptionHandler({PersonAlreadyExistsException.class})
    @ResponseStatus(HttpStatus.CONFLICT)
    public ErrorResponse handlePersonAlreadyExists(final PersonAlreadyExistsException e) {
        return new ErrorResponse(e.getMessage());
    }
}
