package com.til.wtcr_service.exception;

public class UserPermissionError extends RuntimeException {

    public UserPermissionError() {
        super("User does not have sufficient permissions.");
    }

}
