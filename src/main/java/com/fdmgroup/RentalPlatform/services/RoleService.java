package com.fdmgroup.RentalPlatform.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.RentalPlatform.model.Role;
import com.fdmgroup.RentalPlatform.repository.RoleRepository;


@Service
public class RoleService implements IRoleService{
	
	@Autowired
	private RoleRepository repo;
	
	@Override
	public Role findByRoleName(String roleName) {
		Optional<Role> optRole = repo.findByRoleName(roleName);
		
		return optRole.orElse(new Role("default role"));
	}

}
