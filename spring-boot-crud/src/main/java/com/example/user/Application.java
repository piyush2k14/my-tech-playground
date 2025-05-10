package com.example.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(Application.class);
	}

	/*
	 * @Bean public RestTemplate restTemplate() { CloseableHttpClient httpClient =
	 * HttpClients.custom().setRedirectStrategy(new LaxRedirectStrategy()).build();
	 * HttpComponentsClientHttpRequestFactory factory = new
	 * HttpComponentsClientHttpRequestFactory(httpClient); return new
	 * RestTemplate(factory); }
	 */
}