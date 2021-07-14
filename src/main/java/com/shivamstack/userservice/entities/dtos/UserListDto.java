package com.shivamstack.userservice.entities.dtos;

import java.util.List;

import com.shivamstack.userservice.entities.User;

public class UserListDto {

	List<User> users;

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
}
