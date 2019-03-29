package com.stackroute.muzix.repository;

import com.stackroute.muzix.domain.Track;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;
//import org.springframework.data.repository.CrudRepository;

@Repository
public interface TrackRepository extends MongoRepository<Track, Integer> {
    @Query
    public Track findByName(String name);
    @Query
    public Track findByTrackId(int id);
}
