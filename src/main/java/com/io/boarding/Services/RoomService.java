package com.io.boarding.Services;

import com.io.boarding.Data.Room;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService implements RoomServiceImpl{

    @Override
    public void addRoom(Room room) {

    }

    @Override
    public void putRoom(Room room) {

    }

    @Override
    public List<Room> getAllRooms() {
        return null;
    }

    @Override
    public Room getOneRoom(Long id) {
        return null;
    }

    @Override
    public List<Room> getRoomsByNoOfBeds(Integer noOfBeds) {
        return null;
    }

    @Override
    public List<Room> getRoomsByUserName(String userName) {
        return null;
    }

    @Override
    public List<Room> getRoomsByAvailability() {
        return null;
    }
}
