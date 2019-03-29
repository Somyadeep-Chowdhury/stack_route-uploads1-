package com.stackroute.lombokDemo.service;

import com.stackroute.lombokDemo.domain.Track;
import com.stackroute.lombokDemo.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TrackServiceImpl implements TrackService {

   private TrackRepository trackRepository;

    @Autowired
    public TrackServiceImpl(TrackRepository trackRepository){
        this.trackRepository=trackRepository;
    }

    @Override
    public Track saveTrack(Track track) {
        Track saveTrack=trackRepository.save(track);
        return saveTrack;
    }

    @Override
    public List<Track> getAllTrack() {
        return trackRepository.findAll();
    }
}
