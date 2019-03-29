package com.stackroute.muzix.component;

import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.services.TrackServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class FeedDataAppStartRunner implements ApplicationRunner {

    private Track feedTrackData = new Track();

    @Autowired
    private TrackServices trackServices;

    public FeedDataAppStartRunner(TrackServices trackServices) {
        this.trackServices = trackServices;
    }

    //TODO: Add all feeder data to a file, don't let it be hardcoded
    @Override
    public void run(ApplicationArguments args) throws Exception {
//        System.out.println("Sing hossana");
//        feedTrackData.setTrackId(1);
//        feedTrackData.setName("Bohemian Rhapsody");
//        feedTrackData.setComment("The best song ever written");
//        trackServices.addTrack(feedTrackData);
//        feedTrackData.setTrackId(2);
//        feedTrackData.setName("Radio Ga Ga Radio Goo Goo");
//        feedTrackData.setComment("Radio, we still love you");
//        trackServices.addTrack(feedTrackData);
//        feedTrackData.setTrackId(3);
//        feedTrackData.setName("Another One bites the dust");
//        feedTrackData.setComment("My personal favorite");
//        trackServices.addTrack(feedTrackData);
    }
}
