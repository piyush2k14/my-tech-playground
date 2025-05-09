package com.example.hello;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.LaxRedirectStrategy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages = { "com.example.hello", "com.example.user" })
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		CloseableHttpClient httpClient = HttpClients.custom().setRedirectStrategy(new LaxRedirectStrategy()) // Enable
																												// redirect
																												// handling
				.build();
		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory(httpClient);
		return new RestTemplate(factory);
	}
}