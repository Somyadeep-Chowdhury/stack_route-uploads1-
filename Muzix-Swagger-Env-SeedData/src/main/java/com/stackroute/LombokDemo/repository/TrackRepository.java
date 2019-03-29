package com.stackroute.LombokDemo.repository;

import com.stackroute.LombokDemo.domain.Track;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackRepository extends JpaRepository<Track,Integer>
{
    //CRUD operations present in JpaRepository//
}
