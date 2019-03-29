package com.stackroute.muzixApplicationTask1.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "Tracks")
@AllArgsConstructor
@NoArgsConstructor
@Data           //without @setter & @getter, @Data can be applied due to lombok(this takes setter, getter as default
public class Track {

    @Id         //table primary key annotation
    //@ApiModelProperty(notes = "unique ID")          //swagger documentation
    private int trackId;

    @ApiModelProperty(notes = "trackname")      //swagger documentation
    private String trackName;
    @ApiModelProperty(notes = "comment")        //swagger documentation
    private String comment;

    public Track( String trackName, String comment) {
        this.trackName = trackName;
        this.comment = comment;
    }

    public Track(String trackName) {
        this.trackName = trackName;
    }
}
