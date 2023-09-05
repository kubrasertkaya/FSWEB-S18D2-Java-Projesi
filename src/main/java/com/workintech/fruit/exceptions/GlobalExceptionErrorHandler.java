package com.workintech.fruit.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionErrorHandler {

    @ExceptionHandler
    public ResponseEntity<FruitResponse> handleException(FruitException fruitException){
        FruitResponse response =new FruitResponse(fruitException.getStatus().value(),
                fruitException.getMessage(),System.currentTimeMillis());
        return new ResponseEntity<>(response,fruitException.getStatus());
    }

    @ExceptionHandler
    public ResponseEntity handlerMappingException(MethodArgumentNotValidException exception){
        List errorList=exception.getBindingResult().
                getFieldErrors().stream().map(fieldError -> {
                    Map<String,String> errorMap=new HashMap<>();
                    errorMap.put(fieldError.getField(),fieldError.getDefaultMessage());
                    return errorMap;
                }).collect(Collectors.toList());
        return ResponseEntity.badRequest().body(errorList);
    }
    @ExceptionHandler
    public ResponseEntity<FruitResponse> handleException(Exception exception){
        FruitResponse response =new FruitResponse(HttpStatus.BAD_REQUEST.value(),
                exception.getMessage(),System.currentTimeMillis());
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }
}
