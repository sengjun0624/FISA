package dev.security.step03_form_login;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloController {

	@GetMapping("/hello")
	public String sayHello(){
		System.out.println("Hello");
		return "Hello";
	}

}

