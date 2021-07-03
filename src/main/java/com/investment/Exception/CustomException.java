package com.investment.Exception;

import java.io.Serializable;

public class CustomException extends Exception implements Serializable {
    private static final long serialVersionUID = 1L;

    private String message;
    private int errorCode;
    private String details;

    public CustomException(ErrorCode errorCode) {
        this.message = errorCode.getMessage();
        this.errorCode = errorCode.getErrorCode();
        this.details = errorCode.getDetails();
    }

    @Override
    public String getMessage() {
        return message;
    }

    public CustomException setMessage(String message) {
        this.message = message;
        return this;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public CustomException setErrorCode(int errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    public String getDetails() {
        return details;
    }

    public CustomException setDetails(String details) {
        this.details = details;
        return this;
    }
}
