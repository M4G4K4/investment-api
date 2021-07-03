package com.investment.Exception;

import java.io.Serializable;

public class CustomException extends Exception implements Serializable {
    private static final long serialVersionUID = 1L;

    private ErrorCode error;

    public CustomException(ErrorCode errorCode) {
        this.error  = errorCode;
    }

    public ErrorCode getError() {
        return error;
    }
}
