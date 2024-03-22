package ru.kravchenko.hw5.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.kravchenko.hw5.exception.ResourceNotFoundException;
import ru.kravchenko.hw5.exception.ValidateBalanceException;
import ru.kravchenko.hw5.model.dto.ErrorDto;

@ControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDto> handleResourceNotFoundException(ResourceNotFoundException e) {
        return new ResponseEntity<>(new ErrorDto(e.getCode(), e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ValidateBalanceException.class)
    public ResponseEntity<ErrorDto> handleValidateBalanceException(ValidateBalanceException e) {
        return new ResponseEntity<>(new ErrorDto(e.getCode(), e.getMessage()), HttpStatus.CONFLICT);
    }
}
