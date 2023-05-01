package com.carranzac.repository;

import java.util.Optional;

import com.carranzac.model.entity.CartEntity;

import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<CartEntity, Long> {
	
	Optional<CartEntity> findByCustomerId(Long customerId);

}
