package com.shivamstack.userservice.util;

import java.util.List;

import org.springframework.stereotype.Component;

import com.shivamstack.userservice.entities.User;
import com.shivamstack.userservice.entities.dtos.UserDto;
import com.shivamstack.userservice.entities.dtos.UserListDto;

@Component
public class UserMapper {

	public UserListDto toUserListDto(List<User> users) {
		UserListDto userListDto = new UserListDto();
		userListDto.setUsers(users);
		return userListDto;
	}

	public User toEntity(UserDto userDto) {
		User user = new User();
		user.setAddress(userDto.getAddress());
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setMailId(userDto.getMailId());
		user.setPhone(userDto.getPhone());
		return user;
	}

	public UserDto toUserDto(User user) {
		UserDto userDto = new UserDto();
		userDto.setAddress(user.getAddress());
		userDto.setFirstName(user.getFirstName());
		userDto.setLastName(user.getLastName());
		userDto.setMailId(user.getMailId());
		userDto.setPhone(user.getPhone());
		return userDto;
	}

}
