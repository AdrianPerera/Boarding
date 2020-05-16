package com.io.boarding.Services;

import com.io.boarding.Data.Boarding;
import com.io.boarding.repository.BoardingRepository;
import com.io.boarding.repository.RoomRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardingService implements BoardingServiceImpl {
    final BoardingRepository boardingRepo;
    final RoomRepository roomRepository;

    public BoardingService(BoardingRepository boardingRepo, RoomRepository roomRepository) {
        this.boardingRepo = boardingRepo;
        this.roomRepository = roomRepository;
    }

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

    @Override
    public void deleteBoardingById(Integer id) {
        if(roomRepository.existsByBoarding_id(id)) roomRepository.deleteRoomsByBoarding_Id(id);
        boardingRepo.deleteBoardingById(id);
    }

    @Override
    public void deleteBoardingByUserName(String userName) {
        boardingRepo.deleteBoardingsByUser_UserName(userName);
    }
}

