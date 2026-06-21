package com.hindustries.util;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String messagePattern, Object... args) {
        super(String.format(messagePattern, args));
    }
}
