package com.shivamstack.userservice.services.servicesImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shivamstack.userservice.controllers.exceptions.OperationFailedException;
import com.shivamstack.userservice.entities.User;
import com.shivamstack.userservice.entities.dtos.UserDto;
import com.shivamstack.userservice.entities.dtos.UserListDto;
import com.shivamstack.userservice.repositories.UserRepository;
import com.shivamstack.userservice.services.UserService;
import com.shivamstack.userservice.util.UserMapper;

@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	private UserMapper userMapper;

	private static final String USER_PRESENT = "User already present.";
	private static final String USER_NOTPRESENT = "User not present.";

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public Optional<UserListDto> getUsers() {
		List<User> users = (List<User>) userRepository.findAll();
		UserListDto userListDto = userMapper.toUserListDto(users);
		return Optional.ofNullable(userListDto);
	}

	@Autowired
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public Optional<UserDto> saveUser(UserDto userDto) {
		User user = userMapper.toEntity(userDto);
		if (checkIfUserExists(user)) {
			throw new OperationFailedException(USER_PRESENT);
		}
		return this.saveUser(user);
	}

	@Override
	public Optional<UserDto> updateUser(long userId, UserDto userDto) {
		Optional<User> user = this.getUser(userId);
		if (!user.isPresent()) {
			throw new OperationFailedException(USER_NOTPRESENT);
		}
		User updatedUser = this.updateUser(user.get(), userDto);
		return this.saveUser(updatedUser);
	}

	@Override
	public Optional<UserDto> getUserById(long userId) {
		Optional<User> user = this.getUser(userId);
		if (!user.isPresent()) {
			throw new OperationFailedException(USER_NOTPRESENT);
		}
		Optional<UserDto> userDto = Optional.ofNullable(userMapper.toUserDto(user.get()));
		return userDto;
	}

	private Optional<User> getUser(long userId) {
		return userRepository.findById(userId);
	}

	private User updateUser(User user, UserDto userDto) {
		user.setAddress(userDto.getAddress());
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setMailId(userDto.getMailId());
		user.setPhone(userDto.getPhone());
		return user;
	}

	private Optional<UserDto> saveUser(User user) {
		Optional<User> savedUser = Optional.ofNullable(userRepository.save(user));
		return Optional.ofNullable(userMapper.toUserDto(savedUser.get()));
	}

	private boolean checkIfUserExists(User user) {
		Optional<User> savedUser = userRepository.findByMailId(user.getMailId());
		if (savedUser.isPresent()) {
			return true;
		}
		return false;
	}

}
