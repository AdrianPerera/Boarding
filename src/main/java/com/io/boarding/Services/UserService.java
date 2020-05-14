package com.io.boarding.Services;

import com.io.boarding.Data.User;
import com.io.boarding.Model.UserForm;
import com.io.boarding.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import sun.invoke.util.BytecodeDescriptor;


import java.util.List;

@Service
public class UserService implements UserServiceImpl {

    @Autowired
    UserRepository userRepository;

    public void addUser(User user){
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        user.setEnabled(true);
        userRepository.save(user);
    }
    public void changePassword(User user){
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public Boolean checkPassword(User oldUser, UserForm newUser){
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        return encoder.matches(newUser.getOldPassword(),oldUser.getPassword());
    }

    public User getUser(String userName){
        return userRepository.findById(userName).get();
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public boolean userExists(String username){
        return userRepository.existsById(username);
    }
}
