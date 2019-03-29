package com.stackroute.muzix.component;

import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzix.exceptions.TrackHasEmptyNameException;
import com.stackroute.muzix.services.TrackServices;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Primary;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@Data
@Primary
public class FeedDataApplicationListener implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    Environment env;
    @Autowired
    TrackServices trackServices;
    Track feedTrackData = new Track();
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {

        feedTrackData.setTrackId(Integer.parseInt(env.getProperty("song.1.id")));
        feedTrackData.setName(env.getProperty("song.1.name"));
        feedTrackData.setComment(env.getProperty("song.1.comment"));
        try {
            trackServices.addTrack(feedTrackData);
        } catch (TrackAlreadyExistsException e) {
            e.printStackTrace();
        } catch (TrackHasEmptyNameException e) {
            e.printStackTrace();
        }

        feedTrackData.setTrackId(Integer.parseInt(env.getProperty("song.2.id")));
        feedTrackData.setName(env.getProperty("song.2.name"));
        feedTrackData.setComment(env.getProperty("song.2.comment"));
        try {
            trackServices.addTrack(feedTrackData);
        } catch (TrackAlreadyExistsException e) {
            e.printStackTrace();
        } catch (TrackHasEmptyNameException e) {
            e.printStackTrace();
        }
        feedTrackData.setTrackId(Integer.parseInt(env.getProperty("song.3.id")));
        feedTrackData.setName(env.getProperty("song.3.name"));
        feedTrackData.setComment(env.getProperty("song.3.comment"));
        try {
            trackServices.addTrack(feedTrackData);
        } catch (TrackAlreadyExistsException e) {
            e.printStackTrace();
        } catch (TrackHasEmptyNameException e) {
            e.printStackTrace();
        }
    }
}
