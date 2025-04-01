package dev.syntax.security.service;

import java.util.List;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import dev.syntax.security.model.User;
import dev.syntax.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

	private final PasswordEncoder passwordEncoder;

	@Override
	public void createUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));

		userRepository.save(user);
	}

	@Override
	public User getUserByUserName(String username) {
		return userRepository.findUserByUsername(username)
			.orElseThrow(() -> new RuntimeException("Client not found"));
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}
}
