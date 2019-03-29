package com.stackroute.muzix.services;

import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzix.exceptions.TrackHasEmptyNameException;
import com.stackroute.muzix.exceptions.TrackNotExistException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TrackServices {
//    @Autowired
//    TrackRepository trackRepository;
//    public void setTrackRepository(TrackRepository trackRepository) {
//    }
    //Comment this out to make the class into an interface
    public Track addTrack(Track track) throws TrackAlreadyExistsException, TrackHasEmptyNameException;
    public Track delTrack(Track track) throws TrackNotExistException;
    public Track modifyTrack(Track track) throws TrackNotExistException;
    public Track displayTrack(Track track) throws TrackNotExistException;
    public List<Track> displayTracks();
}
