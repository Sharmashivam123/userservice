package com.shivamstack.userservice.controllers;

import static com.shivamstack.userservice.util.ApplicationConstants.USER_URI;
import static com.shivamstack.userservice.util.ApplicationConstants.USERS;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shivamstack.userservice.controllers.exceptions.DataNotAvailableException;
import com.shivamstack.userservice.controllers.exceptions.OperationFailedException;
import com.shivamstack.userservice.entities.dtos.UserDto;
import com.shivamstack.userservice.entities.dtos.UserListDto;
import com.shivamstack.userservice.services.UserService;

@RestController
@RequestMapping(USERS)
public class UserController {

	private UserService userService;
	private static final String DATA_NOT_AVAILABLE = "No Content: No user is registered.";
	private static final String STORE_OPERATION_FAILED = "Error while storing user information.";
	private static final String OPERATION_FAILED = "Error while retrieving user.";
	private static final String UPDATE_OPERATION_FAILED = "Error while UPDATE user.";

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	public ResponseEntity<UserListDto> getUsers() {
		Optional<UserListDto> userListOptional = userService.getUsers();
		if (!userListOptional.isPresent()) {
			throw new DataNotAvailableException(DATA_NOT_AVAILABLE);
		}
		return new ResponseEntity<>(userListOptional.get(), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<UserDto> saveUser(@RequestBody UserDto userDto) {
		Optional<UserDto> savedUserDto = userService.saveUser(userDto);
		if (!savedUserDto.isPresent()) {
			throw new OperationFailedException(STORE_OPERATION_FAILED);
		}
		return new ResponseEntity<>(savedUserDto.get(), HttpStatus.ACCEPTED);
	}

	@GetMapping(USER_URI)
	public ResponseEntity<UserDto> getUser(@PathVariable(name = "userId") long userId) {
		Optional<UserDto> optionalUser = userService.getUserById(userId);
		this.checkUserAvailability(optionalUser);
		return new ResponseEntity<>(optionalUser.get(), HttpStatus.OK);
	}

	@PutMapping(USER_URI)
	public ResponseEntity<UserDto> updateUser(@PathVariable(name = "userId") long userId,
			@RequestBody UserDto userDto) {
		Optional<UserDto> updatedUser = userService.updateUser(userId, userDto);
		if(!updatedUser.isPresent()) {
			throw new OperationFailedException(UPDATE_OPERATION_FAILED);
		}
		return new ResponseEntity<>(updatedUser.get(), HttpStatus.ACCEPTED);
	}

	private void checkUserAvailability(Optional<UserDto> optionalUser) {
		if (!optionalUser.isPresent()) {
			throw new OperationFailedException(OPERATION_FAILED);
		}
	}
}
