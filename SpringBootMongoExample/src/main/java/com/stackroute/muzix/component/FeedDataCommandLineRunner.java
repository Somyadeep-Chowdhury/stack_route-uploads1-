package com.stackroute.muzix.component;

import com.stackroute.muzix.domain.Track;
import com.stackroute.muzix.services.TrackServices;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Component
@Data
@PropertySource("application.properties")
public class FeedDataCommandLineRunner implements CommandLineRunner {
    private Track feedTrackData = new Track();
    @Value("${song.total}")
    private int totalSongs;
    @Value("${song.1.id}")
    private int id1;
    @Value("${song.1.name}")
    private String name1;
    @Value("${song.1.comment}")
    private String comment1;
    @Value("${song.2.id}")
    private int id2;
    @Value("${song.2.name}")
    private String name2;
    @Value("${song.2.comment}")
    private String comment2;
    @Value("${song.3.id}")
    private int id3;
    @Value("${song.3.name}")
    private String name3;
    @Value("${song.3.comment}")
    private String comment3;


    @Autowired
    Environment env;
    @Autowired
    private TrackServices trackServices;
    //TODO: Add all feeder data to a file, don't let it be hardcoded
    //TODO: Find a better way to write expressions for @Value tag
    @Override
    public void run(String... args) throws Exception {
//        System.out.println(env.getProperty("app.name"));
//        System.out.println(env.getProperty("JAVA_HOME"));
//        feedTrackData.setTrackId(id1);
//        feedTrackData.setName(name1);
//        feedTrackData.setComment(comment1);
//        trackServices.addTrack(feedTrackData);
//        feedTrackData.setTrackId(Integer.parseInt(env.getProperty("song.1.id")));
//        feedTrackData.setName(env.getProperty("song.1.name"));
//        feedTrackData.setComment(env.getProperty("song.1.comment"));
//        trackServices.addTrack(feedTrackData);
//
//        feedTrackData.setTrackId(id2);
//        feedTrackData.setName(name2);
//        feedTrackData.setComment(comment2);
//        trackServices.addTrack(feedTrackData);
//
//        feedTrackData.setTrackId(id3);
//        feedTrackData.setName(name3);
//        feedTrackData.setComment(comment3);
//        trackServices.addTrack(feedTrackData);
    }
}
