package com.example.magic8ball.exceptions;

public class BodyFormatException extends Throwable {
    public BodyFormatException() {
    }

    public BodyFormatException(String message) {
        super(message);
    }

    public BodyFormatException(String message, Throwable cause) {
        super(message, cause);
    }
}
