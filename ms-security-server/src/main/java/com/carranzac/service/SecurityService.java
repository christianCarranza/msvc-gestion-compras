package com.carranzac.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.carranzac.configuration.error.InvalidCredentialsException;
import com.carranzac.configuration.security.JwtUtil;
import com.carranzac.model.dto.AuthRequestDto;
import com.carranzac.model.dto.AuthResponseDto;
import com.carranzac.model.entity.UserEntity;
import com.carranzac.repository.UserRepository;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Transactional(readOnly = true)
@Slf4j
@Service
@RequiredArgsConstructor
public class SecurityService implements UserDetailsService {
    
    private final UserRepository usuarioRepository;
    
    private final PasswordEncoder passwordEncoder;
    
    private final JwtUtil jwtTokenCross;
    
    public AuthResponseDto login(AuthRequestDto request) {
    	UserEntity userEntity = validateCredentials(request);
		List<String> roles = userEntity.getRoles().stream().map(rol -> rol.getName()).collect(Collectors.toList());
		AuthResponseDto response = new AuthResponseDto();
		response.setAccessToken(jwtTokenCross.generateToken(userEntity.getUserName(), roles));
		return response;
    }

    private UserEntity validateCredentials(AuthRequestDto request) {
    	Optional<UserEntity> result = usuarioRepository.findByUserName(request.getUserName());
        if (!result.isPresent()|| !passwordEncoder.matches(request.getPassword(), result.get().getPassword())) {
        	throw new InvalidCredentialsException("Invalid credentials", HttpStatus.UNAUTHORIZED);
        }
        return result.get();
    }

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("loadUserByUsername");
		Optional<UserEntity> result = usuarioRepository.findByUserName(username);
		if(!result.isPresent()) {
			throw new UsernameNotFoundException("User not found");
		}
		UserEntity usuarioEntity = result.get();
		List<String> roles = usuarioEntity.getRoles().stream().map(rol -> rol.getName()).collect(Collectors.toList());
		Collection<GrantedAuthority> authorities = roles.stream().map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());
		log.info("loadUserByUsername ok");
		return new User(usuarioEntity.getUserName(), usuarioEntity.getPassword(), authorities);
	}

}
