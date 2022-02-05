package com.cjss.ecommerce.ProductsService.Exceptions;


import com.cjss.ecommerce.ProductsService.Exceptions.errors.DuplicateProduct;
import com.cjss.ecommerce.ProductsService.Exceptions.errors.ProductNotFound;
import com.cjss.ecommerce.ProductsService.models.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@RestControllerAdvice
public class CustomizedExceptionHandling extends ResponseEntityExceptionHandler {

    @ExceptionHandler(DuplicateProduct.class)
    public ResponseEntity<Object> DuplicateProductHandleExceptions(Exception exception, WebRequest webRequest) {
        ExceptionResponse response = new ExceptionResponse();
        response.setTimestamp(String.valueOf(LocalDateTime.now()));
        response.setMessage(exception.getLocalizedMessage());
        System.out.println(response.getMessage());
        return     new ResponseEntity<Object>(response, HttpStatus.UNPROCESSABLE_ENTITY);
    }
    @ExceptionHandler(ProductNotFound.class)
    public ResponseEntity<Object> ProductNotFoundHandleExceptions(Exception exception, WebRequest webRequest) {
        ExceptionResponse response = new ExceptionResponse();
        response.setTimestamp(String.valueOf(LocalDateTime.now()));
        response.setMessage(exception.getLocalizedMessage());
        System.out.println(response.getMessage());
        return     new ResponseEntity<Object>(response, HttpStatus.NOT_FOUND);
    }


}
