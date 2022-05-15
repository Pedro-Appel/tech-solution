package com.spring.appel.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.appel.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID>  {
	
	Optional<User> findByName(String name);
}
