package com.stackroute.LombokDemo.service;

import com.stackroute.LombokDemo.domain.Track;

import java.util.List;

public interface TrackService
{
    public Track saveTrack(Track track);

    public List<Track> getAllTracks();

}
