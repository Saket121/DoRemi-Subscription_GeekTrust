package com.example.geektrust.exceptions;

public class AddSubscriptionFailedException extends RuntimeException {
    public AddSubscriptionFailedException(String message) {
        super(message);
    }
}