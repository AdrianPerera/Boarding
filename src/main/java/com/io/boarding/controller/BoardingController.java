package com.io.boarding.controller;

import com.io.boarding.Data.Boarding;
import com.io.boarding.Data.User;
import com.io.boarding.Services.BoardingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.function.BinaryOperator;

@Controller
@RequestMapping("/boarding")
public class BoardingController {

    @Autowired
    BoardingService boardingService;

    @PostMapping(value = "/add")
    public @ResponseBody String saveUser(@RequestBody Boarding boarding) {
        boardingService.addBoarding(boarding);
        return "success";
    }

    @GetMapping(value = "/getAll")
    public @ResponseBody List<Boarding> getAllBoardings(){
        return boardingService.getAllBoardings();
    }

    @GetMapping(value = "/get/{userName}")
    public @ResponseBody List<Boarding> getAllBoardingData(@PathVariable String userName) {
        return boardingService.getBoardingsByUserName(userName);
    }

    @GetMapping(value = "/get")
    public @ResponseBody List<Boarding> getBoardingsByRooms(@RequestParam Integer n) {
        return boardingService.getBoardingByNoOfRooms(n);
    }
    @GetMapping(value = "/get/available")
    public @ResponseBody List<Boarding> getBoardingByAvailability( ){
        return boardingService.getBoardingsByAvailability();
    }
    @GetMapping(value = "/get/beds/{no}")
    public @ResponseBody List<Boarding> getBoardingsByNoOfBeds(@PathVariable Integer no){
        return boardingService.getBoardingsByNoOfBeds(no);
    }

}
