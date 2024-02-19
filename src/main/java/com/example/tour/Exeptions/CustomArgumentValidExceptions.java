package com.example.tour.Exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class CustomArgumentValidExceptions {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleValidationException(MethodArgumentNotValidException ex){
        Map<String,String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error)->{
            errors.put(((FieldError)error).getField(),error.getDefaultMessage());
        });

        ApiError apiError = new ApiError();
        apiError.setStatusCode(HttpStatus.BAD_REQUEST.value());
        apiError.setDateTime(LocalDateTime.now());
        apiError.setFields(errors);


        return new ResponseEntity<>(apiError,HttpStatus.NOT_FOUND);
    }
}
