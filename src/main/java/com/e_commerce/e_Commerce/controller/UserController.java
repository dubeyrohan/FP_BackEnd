package com.e_commerce.e_Commerce.controller;


import com.e_commerce.e_Commerce.entities.User;
import com.e_commerce.e_Commerce.services.UserService;
import com.e_commerce.e_Commerce.services.implementation.UserServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/{email}/{password}")
    public User getUser(@PathVariable("email") String email,@PathVariable("password") String password) throws Exception{

        User user = this.userService.getUser(email,password);
        return ResponseEntity.ok(user).getBody();
    }

    //Exception handler for invalid password
    @ExceptionHandler(UserServiceImplement.InvalidPasswordException.class)
    public ResponseEntity<String> handleInvalidPassword(UserServiceImplement.InvalidPasswordException ex) {
        //HttpStatus.UNAUTHORIZED here unauthorized will give error in 401
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ex.getMessage());
    }

    //Exception handler for User not found - Runtime Error
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntime(RuntimeException ex) {
        //HttpStatus.NOT_FOUND here NOT_FOUND will give error in 404
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }


    //delete the user
    //public void deleteUser()
}
