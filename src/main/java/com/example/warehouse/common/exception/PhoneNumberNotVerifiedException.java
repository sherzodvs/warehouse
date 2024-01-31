package com.example.warehouse.common.exception;

public class PhoneNumberNotVerifiedException extends RuntimeException{
    public PhoneNumberNotVerifiedException(String message) {
        super(message);
    }

    public PhoneNumberNotVerifiedException(String message, Throwable cause) {
        super(message, cause);
    }
}
