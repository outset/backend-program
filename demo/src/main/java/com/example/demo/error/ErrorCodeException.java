package com.example.demo.error;

import lombok.Setter;

@Setter
public class ErrorCodeException extends RuntimeException implements IErrorCode {
    private Integer code;
    private String message;

    public ErrorCodeException(IErrorCode iErrorCode) {
        this.code = iErrorCode.getCode();
        this.message = iErrorCode.getMessage();
    }

    @Override
    public Integer getCode() {
        return null;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
