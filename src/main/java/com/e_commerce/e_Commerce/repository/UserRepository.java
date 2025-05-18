package com.e_commerce.e_Commerce.repository;

import com.e_commerce.e_Commerce.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    public User findByEmail(String username);
}
