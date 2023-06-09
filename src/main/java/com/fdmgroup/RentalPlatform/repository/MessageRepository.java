package com.fdmgroup.RentalPlatform.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fdmgroup.RentalPlatform.model.Message;
import com.fdmgroup.RentalPlatform.model.Product;
import com.fdmgroup.RentalPlatform.model.User;


@Repository
public interface MessageRepository extends JpaRepository<Message, Integer>{

	List<Message> findBySubject(String subject);

	List<Message> findByOwner(User user);

	List<Message> findByProduct(Product product);

	List<Message> findByBuyer(User user);

	List<Message> findByOwnerOrBuyer(User owner, User buyer);

}
