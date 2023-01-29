package com.fdmgroup.RentalPlatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fdmgroup.RentalPlatform.model.Address;


@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

}
