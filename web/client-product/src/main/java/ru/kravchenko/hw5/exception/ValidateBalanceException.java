package ru.kravchenko.hw5.exception;

public class ValidateBalanceException extends RuntimeException{
    private final String code;
    public ValidateBalanceException(String message, String code) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
