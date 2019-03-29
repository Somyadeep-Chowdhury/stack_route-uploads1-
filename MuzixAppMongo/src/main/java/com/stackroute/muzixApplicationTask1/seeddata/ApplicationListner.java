package com.stackroute.muzixApplicationTask1.seeddata;

import com.stackroute.muzixApplicationTask1.domain.Track;
import com.stackroute.muzixApplicationTask1.exceptions.TrackAlreadyExistsException;
import com.stackroute.muzixApplicationTask1.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class ApplicationListner implements ApplicationListener<ContextRefreshedEvent> {
    private TrackService trackService;

    @Autowired
    public ApplicationListner(TrackService trackService){
        this.trackService=trackService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        try {
            trackService.saveTrack(new Track("I took a pill in ibiza","mike poshner"));
        } catch (TrackAlreadyExistsException e) {
            e.getMessage();
        }

    }
}
