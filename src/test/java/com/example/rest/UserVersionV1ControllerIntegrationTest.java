package com.example.rest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;

import com.example.SpringSwaggerApplicationIntegrationTests;
import com.example.model.User;

@Transactional
public class UserVersionV1ControllerIntegrationTest extends SpringSwaggerApplicationIntegrationTests {

	private static final Logger logger = LoggerFactory.getLogger(UserVersionV1ControllerIntegrationTest.class);

	@BeforeAll
	public static void beforeAll() {
		logger.info("before all called for UserVersionV1ControllerIntegrationTest.");
	}

	@Test
	public void save_return201() {
		String rootUri = testRestTemplate.getRootUri();
		User user = new User(0, "fff@gmail.com", "sfsdfs", "fsdfsdfs0");
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<User> entity = new HttpEntity<>(user, headers);
		ResponseEntity<User> response = testRestTemplate.postForEntity(rootUri + "/api/v1/users", entity, User.class);
		assertTrue(response.getStatusCode() == HttpStatus.CREATED);
	}
}
