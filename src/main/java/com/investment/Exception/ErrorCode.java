package com.investment.Exception;

public enum ErrorCode {
    BAD_CREDENTIALS("Bad credentials provided",401,"email or password are wrong"),
    USER_NOT_FOUND("User not found",404,"ID or emails are not correct"),
    ERROR_GENERATING_TOKEN("Error generating token",500,"Error when creating token");


    private String message;
    private int errorCode;
    private String details;

    ErrorCode(String message, int errorCode, String details) {
        this.message = message;
        this.errorCode = errorCode;
        this.details = details;
    }

    public String getMessage() {
        return message;
    }

    public ErrorCode setMessage(String message) {
        this.message = message;
        return this;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public ErrorCode setErrorCode(int errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    public String getDetails() {
        return details;
    }

    public ErrorCode setDetails(String details) {
        this.details = details;
        return this;
    }
}
