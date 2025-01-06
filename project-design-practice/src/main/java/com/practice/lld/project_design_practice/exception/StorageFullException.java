package com.practice.lld.project_design_practice.exception;

public class StorageFullException extends RuntimeException {

    public StorageFullException(String message) {
        super(message);
    }
}
