package com.stackroute.lombokDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stackroute.lombokDemo.domain.Track;

public interface TrackRepository extends JpaRepository<Track,Integer> {
    //we extending this because we are extending jparepo methods like CRUD
}

