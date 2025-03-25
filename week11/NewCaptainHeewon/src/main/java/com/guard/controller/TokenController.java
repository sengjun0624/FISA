package com.guard.controller;

import org.springframework.security.oauth2.jose.jws.SignatureAlgorithm;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import io.jsonwebtoken.Jwts;

import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/api/auth")
public class TokenController {

	private final ConcurrentHashMap<String, String> authCodeStore = new ConcurrentHashMap<>();

	private static final String SECRET_KEY = "my-secret-key"; // JWT 서명 키

	@PostMapping("/token")
	public ResponseEntity<String> getToken(@RequestParam String code) {
		// Authorization Code 검증
		if (!authCodeStore.containsValue(code)) {
			return ResponseEntity.status(400).body("Invalid authorization code");
		}

		// Access Token 생성 (JWT)
		String accessToken = Jwts.builder()
			.setSubject("user")
			.setIssuedAt(new Date())
			.setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 1000)) // 1시간 유효
			.signWith(SignatureAlgorithm.HS256, SECRET_KEY)
			.compact();

		return ResponseEntity.ok("Access Token: " + accessToken);
	}
}
