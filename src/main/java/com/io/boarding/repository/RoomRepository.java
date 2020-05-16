package com.io.boarding.repository;

import com.io.boarding.Data.Room;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room ,Long> {
    List<Room> findAllByAvailabilityIsTrue();
    List<Room> findAllByNoOfBedsAndAvailabilityIsTrue(Integer noOfBeds);
    List<Room> findAllByNoOfBeds(Integer noOfBeds);
    List<Room> findAllByBoarding_id(Integer id);
    @Transactional
    void deleteRoomsByBoarding_Id(Integer boarding_id);
    @Transactional
    void deleteRoomById(Long id);
    Boolean existsByBoarding_id(Integer boarding_id);
 }
