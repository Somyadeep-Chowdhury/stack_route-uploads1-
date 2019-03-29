//TODO: Do all TODOs
package com.stackroute.muzix.controller;

import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.exceptions.ControllerException;
import com.stackroute.muzix.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzix.exceptions.TrackHasEmptyNameException;
import com.stackroute.muzix.exceptions.TrackNotExistException;
import com.stackroute.muzix.services.TrackServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("muzix/v1/")
public class MuzixController {
    //TODO: Find out why Autowired objects need constructors in the new class
    private TrackServices trackServices;
    private ControllerException ec;
    private Track track1 = new Track();

    @Autowired
    public MuzixController(TrackServices trackServices, ControllerException ec) {
        this.trackServices = trackServices;
        this.ec = ec;
    }

    //TODO: Find out what logref means
    @PostMapping(value = "/track")
    public ResponseEntity<?> newTrack(@RequestBody Track track) {
        try {
            Track track1 = trackServices.addTrack(track);
        } catch (TrackHasEmptyNameException e) {
            return ec.trackHasEmptyNameException(e);
        } catch (TrackAlreadyExistsException e) {
            return ec.trackAlreadyExistsException(e);
        }
        return new ResponseEntity<Track>(track, HttpStatus.OK);
    }
    @DeleteMapping(value = "/track/{id}")
    public ResponseEntity<?> delTrack(@PathVariable("id") int id) throws TrackNotExistException {
        track1.setTrackId(id);
        try {
            track1 = trackServices.delTrack(track1);
        } catch (TrackNotExistException e) {
            return ec.trackNotExistException(e);
        }
        return new ResponseEntity<Track>(track1, HttpStatus.OK);
    }
    @PutMapping(value = "/track/{id}")
    public ResponseEntity<?> modifyTrackComments(@PathVariable("id") int id, @RequestBody Track track) {
//        track1.setTrackId(id);
//        track1.setComment(track.getComment());
        track.setTrackId(id);
        try {
            track1 = trackServices.modifyTrack(track);
        } catch (TrackNotExistException e) {
            return ec.trackNotExistException(e);
        }
        return new ResponseEntity<Track>(track1, HttpStatus.OK);
    }
    //TODO: Find out why GET does not support body in postman
    @GetMapping(value = "/track/{id}")
    public ResponseEntity<?> searchTrack(@PathVariable("id") int id) throws TrackNotExistException {
        track1.setTrackId(id);
        try {
            track1 = trackServices.displayTrack(track1);
        } catch (TrackNotExistException e) {
            return ec.trackNotExistException(e);
        }
        return new ResponseEntity<Track>(track1, HttpStatus.OK);
    }
    @GetMapping(value = "/tracks")
    public ResponseEntity<List<Track>> displayAlltracks() {
        List<Track> tracklist= trackServices.displayTracks();
        return new ResponseEntity<List<Track>>(tracklist, HttpStatus.OK);
    }
}
