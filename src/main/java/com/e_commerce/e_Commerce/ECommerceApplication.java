package com.e_commerce.e_Commerce;

import com.e_commerce.e_Commerce.entities.User;
import com.e_commerce.e_Commerce.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ECommerceApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	public static void main(String[] args) {

		SpringApplication.run(ECommerceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("starting");

//		User user= new User();
//		user.setEmail("abcunique001@gmail.com");
//		user.setFirstName("Crown");
//		user.setLastName("Crown");
//		user.setPassword("P4ssw0rd");
//
//		User firstUser = this.userService.createUser(user);
//		System.out.println(firstUser.getEmail());
	}
}
