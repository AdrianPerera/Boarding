package com.io.boarding.Services;

import com.io.boarding.Data.User;
import com.io.boarding.Model.UserForm;

import java.util.List;

public interface UserServiceImpl{
     void addUser(User user);
     void changePassword(User user);
     void deleteUserById(String userName);
     Boolean checkPassword(User oldUser, UserForm newUser);
     User getUser(String userName);
     List<User> getAllUsers();
     boolean userExists(String userName);
}
