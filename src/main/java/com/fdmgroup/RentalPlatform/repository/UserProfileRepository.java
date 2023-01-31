package com.fdmgroup.RentalPlatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fdmgroup.RentalPlatform.model.User;

@Repository
public interface UserProfileRepository extends JpaRepository<User, Integer>{

}
