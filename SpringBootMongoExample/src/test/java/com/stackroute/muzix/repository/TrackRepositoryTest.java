package com.stackroute.muzix.repository;

import com.stackroute.muzix.MuzixApplication;
import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.services.TrackDBServicesImpl;
import lombok.Data;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataMongoTest
public class TrackRepositoryTest {
    @Autowired
    private TrackRepository trackRepository;

    Track track;
    @Before
    public void setUp() {
        track = new Track(1, "ewewew", "wewew");
//        track.setComment("ttt");
//        track.setName("JJ");
//        track.setTrackId(1);
    }

    @Test
    public void testSave() {
        System.out.println("333");
        track=new Track(1, "abc", "sdsd");
        System.out.println(track);
        trackRepository.save(track);
        Track retreivedTrack = trackRepository.findByTrackId(track.getTrackId());
        assertEquals(track, retreivedTrack);
    }
}