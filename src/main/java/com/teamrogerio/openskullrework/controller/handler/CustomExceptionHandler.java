package com.teamrogerio.openskullrework.controller.handler;

import com.teamrogerio.openskullrework.controller.exception.*;
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

    @ExceptionHandler({ProblemsToUploadImageException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleProblemsToUploadImage(final ProblemsToUploadImageException e) {
        return new ErrorResponse(e.getMessage());
    }

    @ExceptionHandler({FileIsNotCompatibleException.class})
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    public ErrorResponse handleFileNotCompatible(final FileIsNotCompatibleException e) {
        return new ErrorResponse(e.getMessage());
    }
}
