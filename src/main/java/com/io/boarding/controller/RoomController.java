package com.io.boarding.controller;

import com.io.boarding.Data.Room;
import com.io.boarding.Services.RoomService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value ="/room" )
public class RoomController {

  final RoomService roomService;

  public RoomController(RoomService roomService) {
    this.roomService = roomService;
  }

  @PostMapping(value = "/add")
  public void addRoom(@RequestBody @Valid Room room){
      roomService.addRoom(room);
  }
  @GetMapping(value="/getAll")
  public @ResponseBody List<Room> getAllRooms(){
      return roomService.getAllRooms();
  }

  @GetMapping(value = "/get/{id}")
  public @ResponseBody Room getOneRoom(@PathVariable Long id){
      return roomService.getOneRoom(id);
  }

  @GetMapping(value = "/get/beds/{no}")
    public @ResponseBody List<Room> getAvailableRoomsByBeds(@PathVariable Integer no){
      return roomService.getAvailableRoomsByNoOfBeds(no);
  }

  @GetMapping(value = "{boarding_id}/get")
    public @ResponseBody List<Room> getRoomsByBoarding(@PathVariable Integer boarding_id){
      return roomService.getRoomsByBoardingId(boarding_id);
  }

  @DeleteMapping(value = "/delete")
  public @ResponseBody String deleteRoomById(@RequestParam Long id){
    try {
      roomService.deleteRoom(id);
      return "delete success";
    }catch (Error e) {
      return "Failed";
    }

  }

}
