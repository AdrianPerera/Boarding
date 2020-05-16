package com.io.boarding.repository;

import com.io.boarding.Data.Boarding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BoardingRepository extends JpaRepository<Boarding,Integer> {
    List<Boarding> findAllByUser_UserName(String userName);
    List<Boarding> findAllByNoOfRooms(Integer noOfRooms);
    List<Boarding> findAllByAvailabilityIsTrue();
    @Transactional
    void deleteBoardingsByUser_UserName(String userName);
    @Transactional
    void deleteBoardingById(Integer id);
    Boolean existsByUser_UserName(String userName);

}
