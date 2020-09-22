package com.wallmart.challenge.Exceptions;

import com.wallmart.challenge.Exceptions.NotFound.NotFoundException;
import com.wallmart.challenge.Exceptions.NotFound.NotFoundExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler {
    @ExceptionHandler
    public final ResponseEntity<Object> handleBrokerException(NotFoundException ex, WebRequest request) {
        NotFoundExceptionResponse exceptionResponse = new NotFoundExceptionResponse(ex.getMessage());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
