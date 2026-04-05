package com.hindustries.util;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String resource, Object id) {
        super(resource + " with id " + id + " not found ");
    }
}
