package com.stackroute.muzix.exceptions;

public class TrackNotExistException extends Throwable {
    private String message;

    public TrackNotExistException() {

    }

    public TrackNotExistException(String message) {

        this.message = message;
    }

    public void setMessage(String the_song_already_exists) {
    }
}
