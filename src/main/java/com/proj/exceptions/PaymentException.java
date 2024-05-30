package com.proj.exceptions;

public class PaymentException extends Exception{

    private String message;

    public PaymentException(String message) {
        super(message);
    }

}
