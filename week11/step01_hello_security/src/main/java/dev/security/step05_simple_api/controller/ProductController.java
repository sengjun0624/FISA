package dev.security.step05_simple_api.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.security.core.Authentication;

import dev.security.step05_simple_api.model.Product;
@Controller
public class ProductController {

	@GetMapping("/products")
	public String showProducts(Model model, Authentication authentication) {
		// In Servlet, HttpSession.getSession(); ...

		// In Spring, 컨트롤러의 메서드 파라미터에 작성하면 SecurityContext에 보관되고 있는
		// Authentication 객체를 얻을 수 있음
		// Authentication -> 인증된 사용자의 정보를 담고 있는 객체(token)

		// 인증된 사용자의 이름을 products.html에 전송
		String username = authentication.getName();
		model.addAttribute("username", username);

		// DB에서 조회된 product 데이터라고 가정
		List<Product> products = new ArrayList<>();
		products.add(new Product("햄버거", 5000));

		model.addAttribute("products", products);

		return "products"; // products.html로 포워딩
	}
}
