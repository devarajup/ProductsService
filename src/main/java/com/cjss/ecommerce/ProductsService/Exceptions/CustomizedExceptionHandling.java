/*
package com.cjss.ecommerce.ProductsService.Exceptions;


import com.cjss.ecommerce.ProductsService.models.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomizedExceptionHandling extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> UserNotFondHandleExceptions(Exception exception, WebRequest webRequest) {
        ExceptionResponse response = new ExceptionResponse();
        response.setTimestamp(String.valueOf(LocalDateTime.now()));
        response.setMessage(exception.getMessage());
        System.out.println(response.getMessage());
        return     new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST);
    }


}*/
