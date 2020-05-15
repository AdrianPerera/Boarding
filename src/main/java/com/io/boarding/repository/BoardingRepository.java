package com.io.boarding.repository;

import com.io.boarding.Data.Boarding;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BoardingRepository extends JpaRepository<Boarding,Integer> {
    List<Boarding> findAllByUser_UserName(String userName);
    List<Boarding> findAllByNoOfRooms(Integer noOfRooms);
    List<Boarding> findAllByAvailabilityIsTrue();

}
