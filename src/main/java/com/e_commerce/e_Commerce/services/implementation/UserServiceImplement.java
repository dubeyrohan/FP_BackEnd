package com.e_commerce.e_Commerce.services.implementation;

import com.e_commerce.e_Commerce.entities.User;
import com.e_commerce.e_Commerce.repository.UserRepository;
import com.e_commerce.e_Commerce.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplement implements UserService {

    @Autowired
    private UserRepository userRepository;


    //Error Handler to show on UI or Postman for Wrong Password
    public class InvalidPasswordException extends RuntimeException {
        public InvalidPasswordException(String message) {
            super(message);
        }
    }

    //Error Handler to show User Already Exist when signing Up
    public class UserAlreadyExistsException extends RuntimeException {
        public UserAlreadyExistsException(String message) {
            super(message);
        }
    }

    //Creating User
    @Override
    public User createUser(User user) throws Exception {

        //Check if user already exists or not
        User local = this.userRepository.findByEmail(user.getEmail());
        if(local != null){
            throw new UserAlreadyExistsException("User Already Exist" + user.getEmail());
        }
        else{
            //Creating user
            local = this.userRepository.save(user);
        }
        return local;
    }


    //getting user by email
    @Override
    public User getUser(String email, String password) throws Exception {
        User user = this.userRepository.findByEmail(email);

        if (user != null) {

            if (user.getPassword().equals(password)) {
                return user;
            } else {
                throw new InvalidPasswordException("Password is wrong");
            }
        }
        else {
            throw new RuntimeException("User Not Found.");
        }
    }

    @Override
    public void deleteUser(long userId) {
        this.userRepository.deleteById(userId);
    }
}
