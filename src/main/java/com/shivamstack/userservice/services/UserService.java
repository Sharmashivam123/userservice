package com.shivamstack.userservice.services;

import java.util.Optional;

import com.shivamstack.userservice.entities.dtos.UserDto;
import com.shivamstack.userservice.entities.dtos.UserListDto;

public interface UserService {

	Optional<UserListDto> getUsers();

	Optional<UserDto> saveUser(UserDto userDto);

	Optional<UserDto> getUserById(long userId);

	Optional<UserDto> updateUser(long userId, UserDto userDto);
}
