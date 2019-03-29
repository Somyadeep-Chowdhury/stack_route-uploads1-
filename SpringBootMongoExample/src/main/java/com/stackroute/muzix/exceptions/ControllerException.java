package com.stackroute.muzix.exceptions;

import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
@ControllerAdvice
public class ControllerException {
    private VndErrors.VndError error;
    @ExceptionHandler(TrackAlreadyExistsException.class)
    public ResponseEntity<VndErrors.VndError> trackAlreadyExistsException(TrackAlreadyExistsException e) {
        error = new VndErrors.VndError("Log message", "The song already exists");
        return new ResponseEntity<VndErrors.VndError>(error, HttpStatus.CONFLICT);
    }

    //TODO: Find out why set message was not working
    @ExceptionHandler(TrackHasEmptyNameException.class)
    public ResponseEntity<VndErrors.VndError> trackHasEmptyNameException(TrackHasEmptyNameException e) {
//        e.setMessage("Song has empty name");
        error = new VndErrors.VndError("Log message", "Song has empty name");
        return new ResponseEntity<VndErrors.VndError>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TrackNotExistException.class)
    public ResponseEntity<VndErrors.VndError> trackNotExistException(TrackNotExistException e) {
//        e.setMessage("No such track exists");
        error = new VndErrors.VndError("Log message", "NOt such track exists");
        return new ResponseEntity<VndErrors.VndError>(error, HttpStatus.NOT_FOUND);
    }
}
