package com.io.boarding.repository;

import com.io.boarding.Data.Boarding;
import com.io.boarding.Data.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface RoomRepository extends JpaRepository<Room ,Long> {
    List<Room> findAllByAvailabilityIsTrue();
    List<Room> findAllByNoOfBedsAndAvailabilityIsTrue(Integer noOfBeds);
    List<Room> findAllByNoOfBeds(Integer noOfBeds);

 }
