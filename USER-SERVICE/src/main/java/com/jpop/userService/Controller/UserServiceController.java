package com.jpop.userService.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.jpop.userService.model.User;
import com.jpop.userService.servicesImpl.UserServiceImpl;

@RestController
@RequestMapping("/users")
public class UserServiceController {
	
	@Autowired
	UserServiceImpl userServiceImpl;
	
	@GetMapping
	public List<User> getAllUsers(){
		return userServiceImpl.getAllUsers();
	}
	
	@GetMapping(value = "/{userId}")
	public ResponseEntity<User> getUserById(@PathVariable Long userId) {
		
		Optional<User> result = userServiceImpl.getUserById(userId);
		if(!result.isPresent()) {
			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(result.get());

	}
	
	@PostMapping
	public ResponseEntity<User> addUser(@RequestBody User user){
		return ResponseEntity.status(HttpStatus.OK).body(userServiceImpl.addUser(user));
	}
	
	@PutMapping(value =  "/{id}")
	public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User user){
		Optional<User> userResult = userServiceImpl.getUserById(id);
		if(!userResult.isPresent()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		return  ResponseEntity.status(HttpStatus.OK).body(userServiceImpl.addUser(user));
	}
	
	@DeleteMapping(value = "/{userId}")
	public ResponseEntity<User> delete(@PathVariable Long userId) {
		Optional<User> userResult = userServiceImpl.getUserById(userId);
		if(!userResult.isPresent()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		userServiceImpl.deleteUser(userResult.get());
		return  ResponseEntity.status(HttpStatus.OK).build();
	
	}
}
