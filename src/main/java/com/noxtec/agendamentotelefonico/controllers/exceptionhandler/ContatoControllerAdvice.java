package com.noxtec.agendamentotelefonico.controllers.exceptionhandler;

import org.postgresql.util.PSQLException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class ContatoControllerAdvice  extends ResponseEntityExceptionHandler {


    @ResponseBody
    @ExceptionHandler(PSQLException.class)
    public ResponseEntity<MessageExceptionGandler> contatoNotFound(Exception exception){
        MessageExceptionGandler error = new MessageExceptionGandler(new Date(), HttpStatus.NOT_FOUND.value(), exception.getLocalizedMessage());
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(ContatoNotFoundException.class)
    public ResponseEntity<Object> handleException(Exception contatoNotFoundException){
        MessageExceptionGandler error = new MessageExceptionGandler(new Date(), HttpStatus.CONFLICT.value(),"Id não encontrado");
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(FavoritoExcpetion.class)
    public ResponseEntity<Object> favoritoHandleException(Exception contatoNotFoundException){
        MessageExceptionGandler error = new MessageExceptionGandler(new Date(), HttpStatus.CONFLICT.value(),"JÁ existe contato marcado como favorito");
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }
}
