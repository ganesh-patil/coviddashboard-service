package com.covid.dashboard.User;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
       // User userData = null;
        try {
            userRepository.save(user);
        } catch (Exception e) {
            //TODO log error
        }
        return user;
    }
}
