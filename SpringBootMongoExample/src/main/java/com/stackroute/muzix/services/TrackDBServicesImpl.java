package com.stackroute.muzix.services;

import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzix.exceptions.TrackHasEmptyNameException;
import com.stackroute.muzix.exceptions.TrackNotExistException;
import com.stackroute.muzix.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackDBServicesImpl implements TrackServices {


    private TrackRepository trackRepository;

    @Autowired
    public TrackDBServicesImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }


    public Track addTrack(Track track) throws TrackAlreadyExistsException, TrackHasEmptyNameException {
        if(trackRepository.existsById(track.getTrackId())) {
            throw new TrackAlreadyExistsException("This track already exists");
        }
        if(track.getName().equals("")) {
            throw new TrackHasEmptyNameException("The track can't have an emtpy name");
        }
        return trackRepository.save(track);
    }

    public Track delTrack(Track track) throws TrackNotExistException {
        if(!trackRepository.existsById(track.getTrackId())) {
            throw new TrackNotExistException("The track does not exist");
        }
        trackRepository.deleteById(track.getTrackId());
        return track;
    }

    public Track modifyTrack(Track track) throws TrackNotExistException {
        if(!trackRepository.existsById(track.getTrackId())) {
            throw new TrackNotExistException("The track does not exist");
        }
        Track track1 = null;
        track1 = trackRepository.findByName(track.getName());
        track1.setComment(track.getComment());
        track1 = trackRepository.save(track);
        return track1;
    }

    public Track displayTrack(Track track) throws TrackNotExistException {
        if(!trackRepository.existsById(track.getTrackId())) {
            throw new TrackNotExistException("The track does not exist");
        }
        return trackRepository.findByTrackId(track.getTrackId());
    }
    public List<Track> displayTracks() {
        return (List<Track>) trackRepository.findAll();
    }
}
