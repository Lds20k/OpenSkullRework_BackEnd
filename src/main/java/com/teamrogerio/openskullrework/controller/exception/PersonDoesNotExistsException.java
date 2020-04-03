package com.teamrogerio.openskullrework.controller.exception;

public class PersonDoesNotExistsException extends Exception {
    public PersonDoesNotExistsException(String msg){
        super(msg);
    }
}
