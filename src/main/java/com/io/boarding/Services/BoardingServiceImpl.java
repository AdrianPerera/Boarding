package com.io.boarding.Services;

import com.io.boarding.Data.Boarding;

import java.util.List;

public interface BoardingServiceImpl {
    void addBoarding(Boarding boarding);
    void putBoarding(Boarding boarding);
    void deleteBoardingById(Integer id);
    void deleteBoardingByUserName(String userName);
    List<Boarding> getAllBoardings();
    Boarding getOneBoarding(Integer id);
    List<Boarding> getBoardingsByUserName(String userName);
    List<Boarding> getBoardingByNoOfRooms(Integer no);
    List<Boarding> getBoardingsByAvailability();
}
