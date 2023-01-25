package com.fdmgroup.RentalPlatform.model;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class User {
	@Id
	@GeneratedValue
	private Integer userId;
	private String username, password, email, firstName, surName;

	@OneToOne
	private Address address;

	@ManyToMany(cascade = CascadeType.PERSIST, targetEntity = Role.class)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<Role> roleList;

	@OneToMany(cascade = CascadeType.PERSIST)
	private List<Product> productList;

	@OneToMany(cascade = CascadeType.PERSIST)
	private List<Product> borrowedProductList;

	public User() {
	}
//	TODO - add constructors

	public Integer getId() {
		return userId;
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public void setId(Integer id) {
		this.userId = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public List<Product> getBorrowedProductList() {
		return borrowedProductList;
	}

	public void setBorrowedProductList(List<Product> borrowedProductList) {
		this.borrowedProductList = borrowedProductList;
	}

	@Override
	public int hashCode() {
		return Objects.hash(password, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(password, other.password) && Objects.equals(username, other.username);
	}

	

}
