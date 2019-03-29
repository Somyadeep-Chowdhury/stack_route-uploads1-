package com.stackroute.muzix.services;

import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzix.exceptions.TrackHasEmptyNameException;
import com.stackroute.muzix.exceptions.TrackNotExistException;
import com.stackroute.muzix.repository.TrackRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;

public class TrackDBServicesImplTest {
    @Mock
    TrackRepository trackRepository;
    @InjectMocks
    TrackDBServicesImpl trackDBServices;
    @Before
    public void initialize() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddNewTrack() throws TrackHasEmptyNameException, TrackAlreadyExistsException {
        Track track = new Track();
        track.setTrackId(5);
        track.setName("new test song");
        track.setComment("new test song comment");
        doReturn(false).when(trackRepository).existsById(track.getTrackId());
        doReturn(track).when(trackRepository).save(track);
        assertEquals(trackDBServices.addTrack(track), track);
    }
    @Test
    public void testDelTrack() throws TrackNotExistException {
        Track track = new Track();
        doReturn(true).when(trackRepository).existsById(track.getTrackId());
        doNothing().when(trackRepository).deleteById(track.getTrackId());
        assertEquals(trackDBServices.delTrack(track), track);
    }
    @Test
    public void testModifyTrack() throws TrackNotExistException {
        Track track = new Track();
        doReturn(true).when(trackRepository).existsById(track.getTrackId());
        doReturn(track).when(trackRepository).findByName(track.getName());
        doReturn(track).when(trackRepository).save(track);
        assertEquals(trackDBServices.delTrack(track), track);
    }
    @Test
    public void testDisplayTrack() throws TrackNotExistException {
        Track track = new Track();
        doReturn(true).when(trackRepository).existsById(track.getTrackId());
        doReturn(track).when(trackRepository).findByTrackId(track.getTrackId());
        assertEquals(trackDBServices.displayTrack(track), track);
    }
    @Test
    public void testDisplayAllTracks() {
        Track track = new Track();
        List<Track> trackList = new ArrayList<Track>();
        doReturn(trackList).when(trackRepository).findAll();
        assertEquals(trackList, trackDBServices.displayTracks());
    }
}