package com.io.boarding.Services;

import com.io.boarding.Data.Room;

import java.util.List;

public interface RoomServiceImpl {
    void addRoom(Room room);
    void putRoom(Room room);
    List<Room> getAllRooms();
    Room getOneRoom(Long id);
    List<Room> getRoomsByNoOfBeds(Integer noOfBeds);
    List<Room> getRoomsByUserName(String userName);
    List<Room> getRoomsByAvailability();

}
