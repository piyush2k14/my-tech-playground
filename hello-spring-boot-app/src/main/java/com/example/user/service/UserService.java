package com.example.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.user.dao.UserDao;
import com.example.user.model.User;

@Service
public class UserService {

//	private static String API_URL = "http://reqres.in/api/users";

//	@Autowired
//	private RestTemplate restTemplate;

	@Autowired
	private UserDao userRepository;

	/*
	 * public UserResponse getExternalUsers() { HttpHeaders headers = new
	 * HttpHeaders(); headers.set("Accept", "application/json");
	 * 
	 * HttpEntity<String> entity = new HttpEntity<>(headers);
	 * 
	 * try { ResponseEntity<String> responseEntity = restTemplate.exchange(API_URL,
	 * HttpMethod.GET, entity, String.class);
	 * 
	 * // If the response is not JSON, handle it gracefully if
	 * (!responseEntity.getHeaders().getContentType().toString().contains(
	 * "application/json")) { throw new RuntimeException("Unexpected content type: "
	 * + responseEntity.getHeaders().getContentType()); }
	 * 
	 * // Convert the response body to UserResponse if valid return
	 * restTemplate.getForObject(API_URL, UserResponse.class); } catch (Exception e)
	 * { System.err.println("Error fetching user: " + e.getMessage()); return null;
	 * // Handle errors as needed } }
	 */

	public List<User> getUsers() {
		return userRepository.findAll();
	}

	public ResponseEntity<User> getUserById(Long id) {
		Optional<User> user = userRepository.findById(id);
		return user.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
	}

	public User createUser(User user) {
		return userRepository.save(user);
	}

	public ResponseEntity<User> updateUserById(Long id, User updatedUser) {
		return userRepository.findById(id).map(existingUser -> {
			updatedUser.setId(existingUser.getId());
			User savedUser = userRepository.save(updatedUser);
			return ResponseEntity.ok(savedUser);
		}).orElse(ResponseEntity.notFound().build());
	}

	public ResponseEntity<User> deleteUserById(Long id) {
		if (userRepository.existsById(id)) {
			userRepository.deleteById(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}

	public ResponseEntity<User> deleteAll() {
		userRepository.deleteAll();
		return ResponseEntity.noContent().build();
	}
}
