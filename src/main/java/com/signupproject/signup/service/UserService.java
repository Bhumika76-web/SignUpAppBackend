package com.signupproject.signup.service;

import com.signupproject.signup.controller.User;
import com.signupproject.signup.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public User getUserById(String id){
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        } else {
            return new User("N/A", "N/A", "N/A","N/A");
        }
    }

    public User getUserByEmail(String email){
        Optional<User> user = userRepository.findByEmail(email);
        if(user.isPresent()){
            return user.get();
        } else {
            return null;
        }
    }


    public User save(User user){
        return userRepository.save(user);
    }

    public User updateUserById(String id, User user){
        userRepository.deleteById(id);
        user.setId(id);
        return userRepository.save(user);
    }

    public void deleteUserById(String id){
        userRepository.deleteById(id);
    }
}
