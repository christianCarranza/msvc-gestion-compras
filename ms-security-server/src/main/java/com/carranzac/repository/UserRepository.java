package com.carranzac.repository;

import java.util.Optional;

import com.carranzac.model.entity.UserEntity;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long>  {
	
	Optional<UserEntity> findByUserName(String userName);
    
}
