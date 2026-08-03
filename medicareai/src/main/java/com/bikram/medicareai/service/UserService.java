package com.bikram.medicareai.service;

import com.bikram.medicareai.entity.User;
import com.bikram.medicareai.exception.DuplicateEmailException;
import com.bikram.medicareai.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.DuplicateFormatFlagsException;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(User user){
       if (userRepository.existsByEmail(user.getEmail())){
           throw new DuplicateEmailException("Email already exists");
       }
        return userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User findUserById(Long id){
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found!"));
    }
}
