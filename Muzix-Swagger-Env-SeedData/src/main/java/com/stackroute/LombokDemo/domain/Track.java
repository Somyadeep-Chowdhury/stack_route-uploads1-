package com.stackroute.LombokDemo.domain;


import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

//no need of getter,setter,constructor or include @Data(combination of all these)//

public class Track
{
      @Id
      @GeneratedValue(strategy = GenerationType.AUTO)
      @ApiModelProperty(notes = "The database generated track Id")
      private  int id;
      @ApiModelProperty(notes = "Name of track")
      private String name;
      @ApiModelProperty(notes = "Comment of track")
      private String comment;
}
