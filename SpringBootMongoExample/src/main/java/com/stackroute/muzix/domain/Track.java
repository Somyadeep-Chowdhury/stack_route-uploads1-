package com.stackroute.muzix.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;

@Document(collection = "Tracks")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Track {
    @Id
    private int trackId;
    private String name;
    private String comment;
}
