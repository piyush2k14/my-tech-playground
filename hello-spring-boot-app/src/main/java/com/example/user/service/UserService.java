package com.example.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.user.model.UserResponse;

@Component
public class UserService {

	private static String API_URL = "http://reqres.in/api/users";

	@Autowired
	private RestTemplate restTemplate;

	public UserResponse getAllUser() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("User-Agent", "MyApp/1.0"); // Example header
		headers.set("Accept", "application/json"); // Ensure the server knows you expect JSON

		HttpEntity<String> entity = new HttpEntity<>(headers);

		try {
			ResponseEntity<String> responseEntity = restTemplate.exchange(API_URL, HttpMethod.GET, entity,
					String.class);

			// Log the response headers and body
			System.out.println("Response Headers: " + responseEntity.getHeaders());
			System.out.println("Response Body: " + responseEntity.getBody());

			// If the response is not JSON, handle it gracefully
			if (!responseEntity.getHeaders().getContentType().toString().contains("application/json")) {
				throw new RuntimeException("Unexpected content type: " + responseEntity.getHeaders().getContentType());
			}

			// Convert the response body to UserResponse if valid
			return restTemplate.getForObject(API_URL, UserResponse.class);
		} catch (Exception e) {
			System.err.println("Error fetching user: " + e.getMessage());
			return null; // Handle errors as needed
		}
	}
}
