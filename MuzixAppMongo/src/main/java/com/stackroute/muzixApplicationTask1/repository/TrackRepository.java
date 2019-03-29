package com.stackroute.muzixApplicationTask1.repository;

import com.stackroute.muzixApplicationTask1.domain.Track;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackRepository extends MongoRepository<Track,Integer> {

   // @Query("SELECT t FROM Track t WHERE t.trackName = ?1")
    public List<Track> findBytrackName(String name);
}
