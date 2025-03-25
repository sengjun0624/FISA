package com.example.demo;


import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api")
public class TransferController {

	private Map<String, Integer> accounts = new HashMap<>();

	public TransferController() {
		accounts.put("user1", 1000);  // 사용자 계좌 잔액
	}

	@PostMapping("/transfer")
	public Map<String, Object> transferMoney(
		@RequestParam String to,
		@RequestParam int amount,
		HttpSession session) {

		String user = (String) session.getAttribute("user");
		if (user == null) {
			return Map.of("error", "Unauthorized");
		}

		int balance = accounts.get(user);
		if (balance < amount) {
			return Map.of("error", "Insufficient funds");
		}

		accounts.put(user, balance - amount);

		System.out.println("balance = " + balance);
		return Map.of("message", "Transferred " + amount + " to " + to);
	}
}
