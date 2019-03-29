package com.stackroute.Muzix.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Images")
//@Getter
//@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class Image {

    @Id
    private String imageId;
    @JsonProperty("text")
    private String imageName;
    @JsonProperty("url")
    private String imageurl;
}