package com.mycity.user.exception;

public class MediaServiceException extends RuntimeException {
    public MediaServiceException(String message) {
        super(message);
    }

    public MediaServiceException(String message, Throwable cause) {
        super(message, cause);
    }
}
