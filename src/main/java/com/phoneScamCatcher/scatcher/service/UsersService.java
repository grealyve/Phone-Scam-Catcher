package com.phoneScamCatcher.scatcher.service;

import com.phoneScamCatcher.scatcher.entity.User;
import com.phoneScamCatcher.scatcher.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    @Autowired
    private final UserRepository userRepository;

    public UsersService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User registerUser(String name, String password, String phoneNumber){
        if (name == null || password == null) {
            return null;
        }else {
            User user = new User();
            user.setName(name);
            user.setPassword(password);
            user.setPhoneNumber(phoneNumber);
            return userRepository.save(user);
        }
    }


    public User authenticate(String phoneNumber, String password){
        return userRepository.findByPhoneNumberAndPassword(phoneNumber, password);
    }
}
