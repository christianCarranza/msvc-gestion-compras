package com.carranzac;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import com.carranzac.model.entity.UserEntity;
import com.carranzac.repository.UserRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository userRepository;
	
	@Test
	void whenGetUser_ThenReturnUser() {
		Optional<UserEntity> userEntity = userRepository.findByUserName("admin");
		assertEquals(true, userEntity.isPresent());
		assertEquals(2, userEntity.get().getRoles().size());
	}

}
