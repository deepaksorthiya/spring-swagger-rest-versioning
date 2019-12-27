package com.example.rest;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.service.UserService;

@RestController
@RequestMapping("/api/v2/users")
public class UserVersionV2Controller {

	@Autowired
	private UserService userService;

	@PostMapping(consumes = "application/json", produces = "application/json")
	public ResponseEntity<User> save(@RequestBody @Valid User user) {
		return new ResponseEntity<User>(userService.save(user), HttpStatus.CREATED);
	}

	@GetMapping(value = "{userId}", produces = "application/json")
	public ResponseEntity<User> getUser(@PathVariable long userId) {
		return new ResponseEntity<User>(userService.findById(userId).get(), HttpStatus.OK);
	}

	@GetMapping(produces = "application/json")
	public ResponseEntity<Page<User>> findAll(@NotNull final Pageable pageable) {
		return new ResponseEntity<Page<User>>(userService.findAll(pageable), HttpStatus.OK);
	}
}
