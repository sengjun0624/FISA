package dev.security.step02_http_basic.config;

// Spring Security와 관련된 Bean들의 설정 정보가 작성된 파일

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // 해당 파일이 설정파일임을 명시
@EnableWebSecurity // 시큐리티와 관련된 설정을 활성화하는 옵션
public class SecurityConfig {

	// 시큐리티와 관련해서 커스터마이징이 필요한 스프링 빈들을 직접 작성, 등록

	/*
		1. SecurityFilterChain이라는 스프링 시큐리티에서 제공하는 스프링 빈을
		개발자가 별도로 등록
		-> Spring Security가 기본으로 동작시키는 옵션이 아닌,
		   개발자만의 별도 옵션을 사용하기 위해 해당 Bean을 커스터마이징 할 수 있도록 하기 위해
		   등록한 것
	 */
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		// 메서드의 인수로 작성된 http라는 지역변수를 통해 시큐리티 관련 옵션들을 커스터마이징 가능

		// HTTP Basic 기반의 인증 방식을 사용하고 싶을 경우,
		http.httpBasic(Customizer.withDefaults());
		// 기본값이었던 Form Login 방식을 비활성화, HTTP Basic 방식으로 활성화

		// 어떤 엔드포인트 경로로 요청이 왔을 때 인증을 수행시키게 할 것인지?
		http.authorizeRequests() // 요청에 대해서 인가를 수행해라
			.anyRequest() // 모든 경로의 요청에 대해(any)
			.authenticated(); // 인증된 사용자만 접근할 수 있어야 함

		return http.build();
	}
}
