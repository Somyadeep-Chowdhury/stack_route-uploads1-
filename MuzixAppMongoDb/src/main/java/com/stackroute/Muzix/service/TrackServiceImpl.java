package com.stackroute.Muzix.service;

import com.stackroute.Muzix.domain.Track;
import com.stackroute.Muzix.exceptions.TrackAlreadyExistsException;
import com.stackroute.Muzix.exceptions.TrackNotFoundException;
import com.stackroute.Muzix.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrackServiceImpl implements TrackService {

    private TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }


    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExistsException

    {
        if(trackRepository.existsById(track.getTrackId())){
            throw new TrackAlreadyExistsException("Track already exists.");
        }
        else {
            Track savedTrack = trackRepository.save(track);

           return savedTrack;
        }
    }


    @Override
    public List<Track> getAllTracks() {
        return trackRepository.findAll();
    }

    @Override
    public Track updateTrack(Track track) {
        track.setTrackName(track.getTrackName());
        track.setComment(track.getComment());
        return trackRepository.save(track);

    }

    @Override
    public Track findByName(String name) {

        return trackRepository.findBytrackName(name);
    }



    @Override
    public Track deleteTrack(String trackId) throws TrackNotFoundException {

            if (trackRepository.existsById(trackId)) {
                trackRepository.deleteById(trackId);
                return deleteTrack(trackId);
            } else {
                throw  new TrackNotFoundException("Track not found");
            }


    }


}

