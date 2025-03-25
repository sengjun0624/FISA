package dev.security.step05_simple_api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dev.security.step05_simple_api.model.User;
import dev.security.step05_simple_api.service.UserService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Controller
@Getter
@RequiredArgsConstructor
public class AuthController {
	private final UserService userService;

	@GetMapping("/login")
	public String viewLoginPage() {
		return "login"; // ViewResolver가 경로에 대한 처리 수행
	}

	@PostMapping("/signup")
	public User createUser(@RequestParam  User user) {
		return userService.signUp(user);
	}
}
