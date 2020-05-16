package com.io.boarding.controller;

import com.io.boarding.Data.User;
import com.io.boarding.Model.UserForm;
import com.io.boarding.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/save")
    public @ResponseBody
    String saveUser(@RequestBody User user) {
        if (!userService.userExists(user.getUserName())) {
            userService.addUser(user);
            return "success";
        } else {
            return "username already exist";
        }
    }

    @GetMapping(value = "/getAll")
    public @ResponseBody
    List<User> getAllusers() {
        return userService.getAllUsers();
    }

    @GetMapping(value = "/get")
    public @ResponseBody
    User getOneUser(@RequestParam String username) {
      return userService.getUser(username);
    }

    @PutMapping(value = "/put")
    public @ResponseBody String putPassword(@RequestBody @Valid UserForm newUser){
        if(userService.userExists(newUser.getUserName())){
            User oldUser=userService.getUser(newUser.getUserName());
            if(userService.checkPassword(oldUser,newUser)){
                oldUser.setPassword(newUser.getNewPassword());
                userService.changePassword(oldUser);
                return "password changed";
            }else {
                return "old password incorrect";
            }
        }else{
            return "invalid username";
        }
    }

    @DeleteMapping(value = "/delete/{userName}")
    public @ResponseBody String deleteUser(@PathVariable String userName){
        userService.deleteUserById(userName);
        return "success";
    }
}