package com.redhat.fuse.boosters.rest.models;

public class ResponseType {

    private String message;

    public ResponseType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}