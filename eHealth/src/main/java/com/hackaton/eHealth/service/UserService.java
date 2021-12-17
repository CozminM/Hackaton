package com.hackaton.eHealth.service;

import com.hackaton.eHealth.entities.User;
import com.hackaton.eHealth.repository.DayDetailsRepository;
import com.hackaton.eHealth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;



    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        userRepository.save(user);
    }


    public User getUserById(Long id) {
        return userRepository.findById(id).get();
//        return new User("activ1","email@emial.com",null);
    }

}
