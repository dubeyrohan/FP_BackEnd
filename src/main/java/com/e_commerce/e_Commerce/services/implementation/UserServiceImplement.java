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

    //Creating User
    @Override
    public User createUser(User user) throws Exception {

        //Check if user already exists or not
        User local = this.userRepository.findByEmail(user.getEmail());
        if(local != null){
            System.out.println("User Already Exist");
            throw new Exception("User Already Exist");
        }
        else{
            //Creating user
            local = this.userRepository.save(user);
        }
        return local;
    }


    //getting user by email
    @Override
    public User getUser(String email) throws Exception {
        if(this.userRepository.findByEmail(email) != null)
            return this.userRepository.findByEmail(email);
        else {
            System.out.println("User Not Found");
            throw new Exception("User Not Found");
        }
    }

    @Override
    public void deleteUser(long userId) {
        this.userRepository.deleteById(userId);
    }
}
