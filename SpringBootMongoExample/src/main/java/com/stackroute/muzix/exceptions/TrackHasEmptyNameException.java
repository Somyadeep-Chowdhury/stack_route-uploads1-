package com.stackroute.muzix.exceptions;

public class TrackHasEmptyNameException extends Exception {
    private String message;

    public TrackHasEmptyNameException() {

    }
    public TrackHasEmptyNameException(String message) {
        this.message = message;
    }

    public void setMessage(String s) {
    }
}
