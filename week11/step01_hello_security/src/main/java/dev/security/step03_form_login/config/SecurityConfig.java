package dev.security.step03_form_login.config;

// Spring Security와 관련된 Bean들의 설정 정보가 작성된 파일

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		// Form login 방식 활성화
		http.formLogin(Customizer.withDefaults());

		http.authorizeHttpRequests()
			.anyRequest()
			.authenticated();

		return http.build();
	}
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// 시큐리티가 기본으로 사용하던 UserDetailsService를 개발자가 재정의하여 사용(커스터마이징)
	@Bean
	public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {

		// 임시로 애플리케이션 실행 기간 동안만 유지시킬 수 있도록 메모리 형태로 관리하는 객체 생성
		var userDetailsService = new InMemoryUserDetailsManager();

		// 테스트 용도로 사용할 User 객체 생성
		UserDetails sampleUser = User.withUsername("gugu")
			.password(passwordEncoder.encode("1234"))
			.authorities("read")
			.build();

		// UserDetailsService에게 해당 sampleUser를 관리하도록 추가
		userDetailsService.createUser(sampleUser);

		return userDetailsService;
	}
}
