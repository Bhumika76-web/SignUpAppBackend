package com.signupproject.signup.controller;

import com.signupproject.signup.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable String id){
        return userService.getUserById(id);
    }


    @RequestMapping(value = "/email/{email}", method = RequestMethod.GET)
    public User getUserByEmail(@PathVariable String email){
        return userService.getUserByEmail(email);
    }


    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public User signUp(@RequestBody User user){
        return userService.save(user);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public User updateUser(@PathVariable String id, @RequestBody User user){
        return userService.updateUserById(id, user);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable String id){
        userService.deleteUserById(id);
    }
}
