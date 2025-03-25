package dev.security.step05_simple_api.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.security.step05_simple_api.model.User;
import dev.security.step05_simple_api.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;

	@Transactional
	public User signUp(User user) {
		String encode = passwordEncoder.encode(user.getPassword());
		user.encodePassword(encode);
		return userRepository.save(user);
	}
}
