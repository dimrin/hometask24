package com.company.dymrin24;

public class FileMaxSizeReachedException extends RuntimeException {
    public FileMaxSizeReachedException(String message) {
        super(message);
    }

    public FileMaxSizeReachedException(String message, Throwable cause) {
        super(message, cause);
    }
}
