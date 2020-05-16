package com.io.boarding.Services;

import com.io.boarding.Data.Room;

import java.util.List;

public interface RoomServiceImpl {
    void addRoom(Room room);
    void putRoom(Room room);
    void deleteRoom(Long id);
    void deleteRoomsByBoardingId(Integer boarding_id);
    List<Room> getAllRooms();
    Room getOneRoom(Long id);
    List<Room> getRoomsByNoOfBeds(Integer noOfBeds);
    List<Room> getAvailableRoomsByNoOfBeds(Integer noOfBeds);
    List<Room> getRoomsByAvailability();
    List<Room> getRoomsByBoardingId(Integer id);
}
