package com.example.tour.Exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class CustomNotFoundTourException {

    @ExceptionHandler(value = {CustomNotFoundException.class})
    public ResponseEntity<ApiError> handlingNotFound(CustomNotFoundException exception){
        ApiError apiError = new ApiError();
        Map<String,String> error = new HashMap<>();
        error.put("Exception", exception.getMessage());

        apiError.setDateTime(LocalDateTime.now());
        apiError.setStatusCode(HttpStatus.NOT_FOUND.value());
        apiError.setFields(error);

        return new ResponseEntity<>(apiError,HttpStatus.NOT_FOUND);
    }
}
