package com.fdmgroup.RentalPlatform.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Role implements GrantedAuthority{
	@Id
	@GeneratedValue
	private Integer roleId;
	
    private String roleName;

    @ManyToMany
    private List<User> userList;

    public Role() {}

    public Role(String roleName) {
		this.roleName = roleName;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getName() {
        return roleName;
    }

    public void setName(String name) {
        this.roleName = name;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return null;
	}
}
