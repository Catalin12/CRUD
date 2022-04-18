package com.springboot.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.model.User;
import com.springboot.service.impl.UserServiceImpl;

@RestController
@RequestMapping("/api/user")
public class UserController {
	private UserServiceImpl userServ;

	
	public UserController(UserServiceImpl userServ) {
		super();
		this.userServ = userServ;
	}

	@PostMapping()
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		//return new ResponseEntity<User>(UserService.saveUser(user), HttpStatus.CREATED);
		
		return new ResponseEntity<User>(userServ.saveUser(user), HttpStatus.CREATED);
	}
	
	//another sutff
	@GetMapping
	public List<User> getAllUsers() {
		return userServ.getAllUsers();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") long userId) {
		return new ResponseEntity<User>(userServ.getUserById(userId), HttpStatus.OK);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") long userId, @RequestBody User user){
		return new ResponseEntity<User>(userServ.updateUser(user, userId), HttpStatus.OK);
	}
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") long userId) {
		userServ.deleteUser(userId);
		return new ResponseEntity<String>("User deleted.", HttpStatus.OK);
		
	}
}
