package ru.kravchenko.paymentservice.exception;

import ru.kravchenko.paymentservice.model.error.IntegrationErrorDto;

public class IntegrationException extends RuntimeException {
    private String code;
    private IntegrationErrorDto integrationErrorDto;

    public IntegrationException(String message, String code) {
        super(message);
        this.code = code;
    }

    public IntegrationException(String message, IntegrationErrorDto integrationErrorDto) {
        super(message);
        this.integrationErrorDto = integrationErrorDto;
    }

    public String getCode() {
        return code;
    }
}
