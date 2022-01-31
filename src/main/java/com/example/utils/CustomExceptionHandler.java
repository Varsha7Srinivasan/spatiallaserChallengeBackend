package com.example.utils;

import com.example.Exceptions.NoPropertyFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NoPropertyFoundException.class)
    public ResponseEntity<Object> handleNotFoundException(NoPropertyFoundException exception, WebRequest webRequest){
        ExceptionResponse exceptionResponse = new ExceptionResponse();
        exceptionResponse.setDateTime(LocalDateTime.now());
        exceptionResponse.setMessage("No Property Found");
        ResponseEntity<Object> entity = new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
        return entity;

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleExceptions(Exception exception, WebRequest webRequest){
      ExceptionResponse response = new ExceptionResponse();
      response.setDateTime(LocalDateTime.now());
      response.setMessage("Something wrong with the server !");
      ResponseEntity<Object> entity = new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
      return entity;
    }
}
