package com.model;

public class Error {
    private Integer isError;
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Error(String s, String message) {
        this.message = message;
    }

    public Integer getError() {
        return isError;
    }

    public void setError(Integer error) {
        isError = error;
    }

    public Error(int isError, String message) {
        this.isError = isError;
        this.message = message;
    }
}
