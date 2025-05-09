package com.example.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.user.model.User;
import com.example.user.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

//	@GetMapping("/getExternalUser")
//    public List<List<UserData>> getAllUser() {
//        UserResponse userResponse = userService.getExternalUsers();
//        if (userResponse == null || userResponse.getData() == null) {
//            throw new RuntimeException("Error fetching user data.");
//        }
//        return Arrays.asList(userResponse.getData());
//    }

	@GetMapping
	public List<User> getInternalUsers() {
		return userService.getUsers();
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id) {
		return userService.getUserById(id);
	}

	@PostMapping
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);
	}

	@PutMapping("/{id}")
	public ResponseEntity<User> updateUserById(@PathVariable Long id, @RequestBody User user) {
		return userService.updateUserById(id, user);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteUserById(@PathVariable Long id) {
		return userService.deleteUserById(id);
	}

	@DeleteMapping
	public ResponseEntity<User> deleteAll() {
		return userService.deleteAll();
	}
}
