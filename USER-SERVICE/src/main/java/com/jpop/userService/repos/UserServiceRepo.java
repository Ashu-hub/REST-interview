package com.jpop.userService.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpop.userService.model.User;

public interface UserServiceRepo extends JpaRepository<User, Long>{

}
