package com.stackroute.Muzix.repository;

import com.stackroute.Muzix.domain.Track;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackRepository extends MongoRepository<Track,String> {

  //  @Query("SELECT t FROM track t WHERE t.trackName-=?1")
    public Track findBytrackName(String name);



}
