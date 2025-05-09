package com.example.user.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.model.UserData;
import com.example.user.model.UserResponse;
import com.example.user.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/")
    public List<List<UserData>> getAllUse() {
        UserResponse userResponse = userService.getAllUser();
        if (userResponse == null || userResponse.getData() == null) {
            throw new RuntimeException("Error fetching user data.");
        }
        return Arrays.asList(userResponse.getData());
    }
}
