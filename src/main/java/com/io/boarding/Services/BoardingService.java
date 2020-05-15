package com.io.boarding.Services;

import com.io.boarding.Data.Boarding;
import com.io.boarding.Data.Room;
import com.io.boarding.repository.BoardingRepository;
import com.io.boarding.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardingService implements BoardingServiceImpl {
    @Autowired
    BoardingRepository boardingRepo;
    @Autowired
    RoomRepository roomRepository;

    @Override
    public void addBoarding(Boarding boarding) {
        boardingRepo.save(boarding);
    }

    @Override
    public void putBoarding(Boarding boarding) {
        boardingRepo.save(boarding);
    }

    @Override
    public List<Boarding> getAllBoardings() {
        return boardingRepo.findAll();
    }

    @Override
    public Boarding getOneBoarding(Integer id) {
        if(boardingRepo.findById(id).isPresent()){
            return boardingRepo.findById(id).get();
        }else{
            return new Boarding();
        }
    }

    @Override
    public List<Boarding> getBoardingsByUserName(String userName) {
        return boardingRepo.findAllByUser_UserName(userName);
    }

    @Override
    public List<Boarding> getBoardingByNoOfRooms(Integer no) {
        return boardingRepo.findAllByNoOfRooms(no);
    }

    @Override
    public List<Boarding> getBoardingsByAvailability() {
        return boardingRepo.findAllByAvailabilityIsTrue();
    }

    public List<Boarding> getBoardingsByNoOfBeds(Integer noOfBeds){
        List<Boarding> boardingList=new ArrayList<>();
        List<Boarding> boardings=boardingRepo.findAll();
        for (Boarding boarding:boardings
             ) {
            for(Room room:boarding.getRooms()){
                if(room.getNoOfBeds().equals(noOfBeds)){
                    boardingList.add(boarding);
                    break;

                }
            }
        }
        return boardingList;
    }

}

