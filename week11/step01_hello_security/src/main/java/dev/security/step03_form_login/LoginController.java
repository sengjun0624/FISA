package dev.security.step03_form_login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class LoginController {
	@GetMapping("/login")
	String login() {
		System.out.println("abc");
		return "login";
	}
}
