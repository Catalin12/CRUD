package com.springboot.service.impl;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springboot.exception.ResourceNotFoundException;
import com.springboot.model.User;
import com.springboot.repository.UserRepository;
import com.springboot.service.UserService;



@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	

	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}
	
	@Override
	public List<User> getAllUsers() {
		
		return userRepository.findAll();
	}

	@Override
	public User getUserById(long id) {
		Optional<User> localUser = userRepository.findById(id);
		if(localUser.isPresent()) {
			return localUser.get();
		}
		else {
			throw new ResourceNotFoundException("user", "id", "id");
		}
	}

	@Override
	public User updateUser(User user, long id) {
		User localUser = userRepository.findById(id).orElseThrow(
				()->new ResourceNotFoundException("User", "id", id));
		localUser.setName(user.getName());
		localUser.setEmail(user.getEmail());
		localUser.setPassword(user.getPassword());
		
		userRepository.save(localUser);
		return localUser;
	}

	@Override
	public void deleteUser(long id) {
		userRepository.findById(id).orElseThrow(
				()->new ResourceNotFoundException("User", "id", id));
		userRepository.deleteById(id);
		
	}
	
	
}