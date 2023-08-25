package com.noxtec.agendamentotelefonico.controllers.exceptionhandler;

public class DuplicidadeException extends RuntimeException{

    public DuplicidadeException(String message) {
        super(message);
    }
}
