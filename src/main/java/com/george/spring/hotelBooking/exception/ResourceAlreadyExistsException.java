package com.george.spring.hotelBooking.exception;

public class ResourceAlreadyExistsException extends RuntimeException {
    public ResourceAlreadyExistsException(String message) { super(message); }
}
