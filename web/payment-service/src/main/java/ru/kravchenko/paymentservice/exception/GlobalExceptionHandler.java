package ru.kravchenko.paymentservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.kravchenko.paymentservice.model.error.IntegrationErrorDto;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(IntegrationException.class)
    public ResponseEntity<IntegrationErrorDto> handleResourceNotFoundException(IntegrationException e) {
        return new ResponseEntity<>(new IntegrationErrorDto(e.getCode(), e.getMessage()), HttpStatus.NOT_FOUND);
    }
}
