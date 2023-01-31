package com.fdmgroup.RentalPlatform.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.RentalPlatform.model.Role;
import com.fdmgroup.RentalPlatform.model.User;
import com.fdmgroup.RentalPlatform.repository.RoleRepository;
import com.fdmgroup.RentalPlatform.repository.UserRepository;

@Service
public class UserService implements IUserService{
	@Autowired
	private UserRepository repo;
	
	@Override
	public User findByUsername(String username) {
		Optional<User> optUser = repo.findByUsername(username);
		return optUser.orElse(new User("default user"));
	}

	@Override
	public User findByUserId(int id) {
		Optional<User> optUser = repo.findByUserId(id);
		return optUser.orElse(new User("default user"));
	}

}
