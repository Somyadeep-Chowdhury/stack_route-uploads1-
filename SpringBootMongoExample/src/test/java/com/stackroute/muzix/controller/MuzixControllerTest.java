package com.stackroute.muzix.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzix.exceptions.TrackHasEmptyNameException;
import com.stackroute.muzix.exceptions.TrackNotExistException;
import com.stackroute.muzix.services.TrackServices;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.*;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class MuzixControllerTest {
    @Autowired
    MockMvc mockMVC;
    @Mock
    TrackServices trackServices;
    @InjectMocks
    MuzixController muzixController;
    @Before
    public void initialize() {
        MockitoAnnotations.initMocks(this);
        mockMVC = MockMvcBuilders.standaloneSetup(muzixController).build();
    }
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void testAddNewTrackSuccess() throws TrackHasEmptyNameException, TrackAlreadyExistsException {
        Track trackDemo = new Track();
        //doReturn has been used because thenReturn needs to know clearly what is the return type
        //in this case, that return type is not known because newtrack could return a response entity of an exception or a new track object
        //when does not excecute the method of service, it simply tells mockito what to return when a service method is executed
        doReturn(trackDemo).when(trackServices).addTrack(trackDemo);
        assertEquals(muzixController.newTrack(trackDemo), new ResponseEntity<Track>(trackDemo, HttpStatus.OK) );
    }
    @Test
    public void testDelTrack() throws TrackHasEmptyNameException, TrackAlreadyExistsException, TrackNotExistException {
        Track trackDemo = new Track();
        doReturn(trackDemo).when(trackServices).delTrack(trackDemo);
        assertEquals(muzixController.delTrack(trackDemo.getTrackId()), new ResponseEntity<Track>(trackDemo, HttpStatus.OK) );
    }
    @Test
    public void testiModifyTrackComments() throws TrackHasEmptyNameException, TrackAlreadyExistsException, TrackNotExistException {
        Track track = new Track();
        Track modifiedTrack = new Track();
        doReturn(modifiedTrack).when(trackServices).modifyTrack(track);
        assertEquals(new ResponseEntity<Track>(modifiedTrack, HttpStatus.OK), muzixController.modifyTrackComments(track.getTrackId(), modifiedTrack));
    }
    @Test
    public void testDisplayTrack() throws TrackHasEmptyNameException, TrackAlreadyExistsException, TrackNotExistException {
        Track trackDemo = new Track();
        doReturn(trackDemo).when(trackServices).displayTrack(trackDemo);

        assertEquals(muzixController.searchTrack(trackDemo.getTrackId()), new ResponseEntity<Track>(trackDemo, HttpStatus.OK) );
    }
    @Test
    public void testDisplayAllTracks() throws TrackHasEmptyNameException, TrackAlreadyExistsException, TrackNotExistException {
        Track trackDemo = new Track();
        Track trackDemo1 = new Track();
        Track trackDemo2 = new Track();
        List<Track> trackList = new ArrayList<Track>();
        trackList.add(trackDemo);
        trackList.add(trackDemo1);
        trackList.add(trackDemo2);

        doReturn(trackList).when(trackServices).displayTracks();
        assertEquals(new ResponseEntity<List<Track>>(trackList, HttpStatus.OK), muzixController.displayAlltracks());
    }
    @Test
    public void testNewTrackMapping() throws Exception {
        Track track = new Track();
        when(trackServices.addTrack(track)).thenReturn(track);
        mockMVC.perform(post("/muzix/v1/track")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(asJsonString(track)))
                .andExpect(status().is2xxSuccessful());

        verify(trackServices, times(1)).addTrack(Mockito.any(Track.class));
        verifyNoMoreInteractions(trackServices);
    }
    @Test
    public void testDeleteTrackMapping() throws Exception, TrackNotExistException {
        Track track = new Track();
        when(trackServices.delTrack(track)).thenReturn(track);
        mockMVC.perform(delete("/muzix/v1/track/{id}", 0)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(asJsonString(track)))
                .andExpect(status().is2xxSuccessful());
        verify(trackServices, times(1)).delTrack(Mockito.any(Track.class));
        verifyNoMoreInteractions(trackServices);
    }
    @Test
    public void testDisplayTrackMapping() throws Exception, TrackNotExistException {
        Track track = new Track();
        when(trackServices.displayTrack(track)).thenReturn(track);
        mockMVC.perform(get("/muzix/v1/track/{id}", 0)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(asJsonString(track)))
                .andExpect(status().is2xxSuccessful());
        verify(trackServices, times(1)).displayTrack(Mockito.any(Track.class));
        verifyNoMoreInteractions(trackServices);
    }
    @Test
    public void testDisplayAllTracksMapping() throws Exception, TrackNotExistException {
        Track track = new Track();
        when(trackServices.displayTracks()).thenReturn(null);
        mockMVC.perform(get("/muzix/v1/tracks")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(asJsonString(track)))
                .andExpect(status().is2xxSuccessful());
        verify(trackServices, times(1)).displayTracks();
        verifyNoMoreInteractions(trackServices);
    }
    @Test
    public void testModifyTrackMapping() throws Exception {
//        Track track = new Track();
//        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
//        when(trackServices.addTrack(track)).thenReturn(track);
//        mockMVC.perform(put("/api/todo/{id}", 1L)
//                .contentType(MediaType.APPLICATION_JSON)
//
//                .body(ow.writeValueAsString(track))
//
//        )
//                .andExpect(status().isOk());
//    }
////        final ResultActions resultActions = mockMVC.perform(put("/muzix/v1/{id}", 0)
////                .contentType(MediaType.APPLICATION_JSON)
////                .body(asJsonString(track)))
////                .andExpect(status().is2xxSuccessful());
//
//        verify(trackServices, times(1)).addTrack(Mockito.any(Track.class));
//        verifyNoMoreInteractions(trackServices);
    }
}
