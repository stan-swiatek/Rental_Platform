package com.fdmgroup.RentalPlatform.services;

import com.fdmgroup.RentalPlatform.model.Role;

public interface IRoleService {

	Role findByRoleName(String roleName);

}
