package com.shivamstack.userservice.repositories;

import static com.shivamstack.userservice.util.DbConstants.FIND_BY_EMAIL;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.shivamstack.userservice.entities.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

	@Query(nativeQuery = true, value = FIND_BY_EMAIL)
	Optional<User> findByMailId(String mailId);
}
