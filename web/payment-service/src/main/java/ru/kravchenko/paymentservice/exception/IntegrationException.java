package ru.kravchenko.paymentservice.exception;

import ru.kravchenko.paymentservice.model.error.IntegrationErrorDto;

public class IntegrationException extends RuntimeException {
    private IntegrationErrorDto integrationErrorDto;

    public IntegrationErrorDto getIntegrationErrorDto() {
        return integrationErrorDto;
    }

    public IntegrationException(String message, IntegrationErrorDto integrationErrorDto) {
        super(message);
        this.integrationErrorDto = integrationErrorDto;
    }
}
