package com.jpop.userService.services;

import java.util.List;
import java.util.Optional;

import com.jpop.userService.model.User;

public interface UserService {
	
	public List<User> getAllUsers();
	
	public Optional<User> getUserById(Long id);
	
	public User addUser(User user);
	
	public void deleteUser(User user);
	
}
