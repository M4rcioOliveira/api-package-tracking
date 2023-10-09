package com.track.distance.model.exception.handler;

import com.track.distance.model.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ClienteException.class})
    public ResponseEntity buildHandlerClienteException(ClienteException exception) {

        return new ResponseEntity(new GeneralResponseException(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, LocalDateTime.now()), HttpStatus.INTERNAL_SERVER_ERROR);

    }


    @ExceptionHandler({ClienteNotFoundException.class})
    public ResponseEntity buildHandlerClienteNotFoundException(ClienteNotFoundException exception) {

        return new ResponseEntity(new GeneralResponseException(exception.getMessage(), HttpStatus.NOT_FOUND, LocalDateTime.now()), HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler({ClienteFoundException.class})
    public ResponseEntity buildHandlerClienteFoundException(ClienteFoundException exception) {

        return new ResponseEntity(new GeneralResponseException(exception.getMessage(), HttpStatus.CONFLICT, LocalDateTime.now()), HttpStatus.CONFLICT);

    }


    @ExceptionHandler({EncomendaNotFoundException.class})
    public ResponseEntity buildHandlerEncomendaNotFoundException(EncomendaNotFoundException exception) {

        return new ResponseEntity(new GeneralResponseException(exception.getMessage(), HttpStatus.NOT_FOUND, LocalDateTime.now()), HttpStatus.NOT_FOUND);

    }


}
