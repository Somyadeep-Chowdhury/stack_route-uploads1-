package com.stackroute.lombokDemo.service;

import com.stackroute.lombokDemo.domain.Track;

import java.util.List;

public interface TrackService {
    public Track saveTrack(Track track);

    public List<Track> getAllTrack();
}
