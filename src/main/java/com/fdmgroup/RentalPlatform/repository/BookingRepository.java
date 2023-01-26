package com.fdmgroup.RentalPlatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fdmgroup.RentalPlatform.model.Booking;


@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer>{

}
