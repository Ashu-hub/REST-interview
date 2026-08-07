package com.jpop.userService.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpop.userService.model.User;
import com.jpop.userService.repos.UserServiceRepo;
import com.jpop.userService.services.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserServiceRepo userServiceRepo;
	
	@Override
	public List<User> getAllUsers() {
		return userServiceRepo.findAll();
	}

	@Override
	public Optional<User> getUserById(Long id) {
		return userServiceRepo.findById(id);
	}

	@Override
	public User addUser(User user) {
		return userServiceRepo.save(user);
	}

	@Override
	public void deleteUser(User user) {
		userServiceRepo.delete(user);
		
	}

}
