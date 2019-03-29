package com.stackroute.lombokDemo.controller;


import com.stackroute.lombokDemo.domain.Track;
import com.stackroute.lombokDemo.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1")

public class TrackController {
    private TrackService trackService;
    @Autowired
    public TrackController(TrackService trackService){
        this.trackService=trackService;
    }

    @GetMapping("track")
    public ResponseEntity<?> getAllTrack() {
        return new ResponseEntity<List<Track>>(trackService.getAllTrack(), HttpStatus.OK);
    }

    @PostMapping("track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track){
        ResponseEntity responseEntity;
        try{
            trackService.saveTrack(track);
            responseEntity=new ResponseEntity<Track>(track, HttpStatus.CREATED);
        }catch (Exception ex){
            responseEntity=new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
        }
        return responseEntity;
    }
}
