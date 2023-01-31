package com.fdmgroup.RentalPlatform.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "booking")
public class Booking {
	@Id
	@GeneratedValue
	private Integer id;
	
	private Date startDate, endDate, bookingDate;
	
	private String status;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Product product;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private User user;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public boolean isFree(Date start, Date end) {
		if(start.after(this.startDate) && start.before(this.endDate)) {
			return false;
		}

		if(this.startDate.after(start) && this.endDate.before(start)) {
			return false;
		}
		
		return true;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
	}
}

//package com.fdmgroup.RentalPlatform.model;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import java.util.Objects;
//
//import javax.persistence.CascadeType;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.JoinTable;
//import javax.persistence.JoinColumn;
//import javax.persistence.OneToMany;
//import javax.persistence.OneToOne;
//
//import org.springframework.data.repository.cdi.Eager;
//
//
//
//@Entity
//public class User {
//	@Id
//	@GeneratedValue
//	private Integer userId;
//	public User(String username, String password, String email, String firstName, String surName) {
//		super();
//		this.username = username;
//		this.password = password;
//		this.email = email;
//		this.firstName = firstName;
//		this.surName = surName;
//	}
//
//	private String username, password, email, firstName, surName;
//
//	@OneToOne(cascade = CascadeType.ALL)
//	private Address address;
//
//	@ManyToMany(cascade = CascadeType.PERSIST, targetEntity = Role.class, fetch = FetchType.EAGER)
//	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
//	
//	private List<Role> roleList = new ArrayList<>();
//
//	@OneToMany(cascade = CascadeType.PERSIST)
//	private List<Product> productList = new ArrayList<>();
//
//	@OneToMany(cascade = CascadeType.PERSIST)
//	private List<Product> borrowedProductList = new ArrayList<>();
//
//	public User() {
//	}
////	TODO - add constructors
//
//	public Integer getId() {
//		return userId;
//	}
//
//	public User(String username) {
//		super();
//		this.username = username;
//	}
//
//	public User(String username, String password, Role role) {
//		super();
//		this.username = username;
//		this.password = password;
//		this.setRole(role);
//	}
//
//	public User(String username, String password) {
//		this.username = username;
//		this.password = password;
//	}
//
//	public void setId(Integer id) {
//		this.userId = id;
//	}
//
//	public String getUsername() {
//		return username;
//	}
//
//	public void setUsername(String username) {
//		this.username = username;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public String getFirstName() {
//		return firstName;
//	}
//
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}
//
//	public String getSurName() {
//		return surName;
//	}
//
//	public void setSurName(String surName) {
//		this.surName = surName;
//	}
//
//	public Address getAddress() {
//		return address;
//	}
//
//	public void setAddress(Address address) {
//		this.address = address;
//	}
//
//	public List<Role> getRoleList() {
//		return roleList;
//	}
//
//	public void setRoleList(List<Role> roleList) {
//		this.roleList = roleList;
//	}
//	
//	
//	
//	public void setRole(Role role) {
//		roleList.add(role);
//	}
//	
//
//	public List<Product> getProductList() {
//		return productList;
//	}
//
//	public void setProductList(List<Product> productList) {
//		this.productList = productList;
//	}
//
//	public List<Product> getBorrowedProductList() {
//		return borrowedProductList;
//	}
//
//	public void setBorrowedProductList(List<Product> borrowedProductList) {
//		this.borrowedProductList = borrowedProductList;
//	}
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(address, email, firstName, password, roleList, surName, username);
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		User other = (User) obj;
//		return Objects.equals(address, other.address) && Objects.equals(email, other.email)
//				&& Objects.equals(firstName, other.firstName) && Objects.equals(password, other.password)
//				&& Objects.equals(roleList, other.roleList) && Objects.equals(surName, other.surName)
//				&& Objects.equals(username, other.username);
//	}
//
//}
