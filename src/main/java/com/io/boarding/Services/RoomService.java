package com.io.boarding.Services;

import com.io.boarding.Data.Room;
import com.io.boarding.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class RoomService implements RoomServiceImpl{

    @Autowired
    RoomRepository roomRepo;

    @Override
    public void addRoom(Room room) {
//        if(!roomRepo.existsById(room.getId()))
        roomRepo.save(room);
    }

    @Override
    public void putRoom(Room room) {
        roomRepo.save(room);
    }

    @Override
    public List<Room> getAllRooms() {
        return roomRepo.findAll();
    }

    @Override
    public Room getOneRoom(Long id) throws NoSuchElementException {
        try {
            return roomRepo.findById(id).get();
        }catch (NoSuchElementException e){
            return new Room();
       }
    }

    @Override
    public List<Room> getRoomsByNoOfBeds(Integer noOfBeds) {
        return roomRepo.findAllByNoOfBeds(noOfBeds);
    }

    @Override
    public List<Room> getAvailableRoomsByNoOfBeds(Integer noOfBeds) {
        return roomRepo.findAllByNoOfBedsAndAvailabilityIsTrue(noOfBeds);
    }

    @Override
    public List<Room> getRoomsByAvailability() {
        return roomRepo.findAllByAvailabilityIsTrue();
    }

    @Override
    public List<Room> getRoomsByBoardingId(Integer id) {
        return roomRepo.findAllByBoarding_id(id);
    }

    @Override
    public void deleteRoom(Long id) {
        roomRepo.deleteRoomById(id);
    }

    @Override
    public void deleteRoomsByBoardingId(Integer boarding_id) {
        roomRepo.deleteRoomsByBoarding_Id(boarding_id);
    }
}
