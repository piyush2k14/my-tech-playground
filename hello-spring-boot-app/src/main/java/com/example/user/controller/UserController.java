package com.example.user.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.model.UserResponse;
import com.example.user.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String hello() {
		UserResponse userResponse = userService.getAllUser();
		if (userResponse == null || userResponse.getData() == null) {
			return "Error fetching user data.";
		}
		return "Hello from Spring Boot with Java 8! Users: " + Arrays.asList(userResponse.getData());
	}
}
