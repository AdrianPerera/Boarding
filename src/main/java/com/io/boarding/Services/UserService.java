package com.io.boarding.Services;

import com.io.boarding.Data.Boarding;
import com.io.boarding.Data.User;
import com.io.boarding.Model.UserForm;
import com.io.boarding.repository.BoardingRepository;
import com.io.boarding.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;



import java.util.List;

@Service
public class UserService implements UserServiceImpl {

    final UserRepository userRepository;
    final BoardingRepository boardingRepository;
    final BoardingService boardingService;

    public UserService(UserRepository userRepository, BoardingRepository boardingRepository, BoardingService boardingService) {
        this.userRepository = userRepository;
        this.boardingRepository = boardingRepository;
        this.boardingService = boardingService;
    }

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

    @Override
    public void deleteUserById(String userName){
        if(boardingRepository.existsByUser_UserName(userName)){
            List<Boarding> boardings=boardingRepository.findAllByUser_UserName(userName);
            for (Boarding boarding:boardings) {
                boardingService.deleteBoardingById(boarding.getId());
            }
            boardingRepository.deleteBoardingsByUser_UserName(userName);
        }
        userRepository.deleteById(userName);
    }
}
