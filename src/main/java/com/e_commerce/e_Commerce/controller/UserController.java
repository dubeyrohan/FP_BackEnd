package com.e_commerce.e_Commerce.controller;


import com.e_commerce.e_Commerce.entities.User;
import com.e_commerce.e_Commerce.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    //creating user
    @PostMapping("/signup")
    public User createUser(@RequestBody User user) throws Exception {
        return this.userService.createUser(user);
    }

    @GetMapping("/{email}")
    public User getUser(@PathVariable("email") String email) throws Exception{
        return this.userService.getUser(email);
    }


    //delete the user
    //public void deleteUser()
}
