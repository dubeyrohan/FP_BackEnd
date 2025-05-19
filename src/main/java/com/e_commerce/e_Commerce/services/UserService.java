package com.e_commerce.e_Commerce.services;

import com.e_commerce.e_Commerce.entities.User;

public interface UserService {

    //Create User
    public User createUser(User user) throws Exception;

    //get user
    public User getUser(String email, String password) throws Exception;

    //delete user
    public void deleteUser(long userId);

}
