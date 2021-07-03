package com.investment.Exception;

public class Payload {
    private String message;
    private int errorCode;
    private String details;

    public Payload(String message, int errorCode, String details) {
        this.message = message;
        this.errorCode = errorCode;
        this.details = details;
    }

    public String getMessage() {
        return message;
    }

    public Payload setMessage(String message) {
        this.message = message;
        return this;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public Payload setErrorCode(int errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    public String getDetails() {
        return details;
    }

    public Payload setDetails(String details) {
        this.details = details;
        return this;
    }
}
