package dev.security.step04_custom_jdbc.config;

import javax.sql.DataSource;

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
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import dev.security.step04_custom_jdbc.encoder.PlainTextPasswordEncoder;

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
	public PasswordEncoder passwordEncoder (){
		return new PlainTextPasswordEncoder();
	}
	@Bean
	public UserDetailsService userDetailsService(DataSource dataSource) {

		// JDBC 기반으로 DB에서 사용자를 조회할 수 있도록 구현체를 지정
		var userDetailsService = new JdbcUserDetailsManager(dataSource);

		return userDetailsService;

		// 현재 DB에 비밀번호는 평문으로 저장이 됨.
		// 별도의 암호화 없이 그냥 평문으로 비밀번호를 검증할 수 있는 커스텀 인코더 객체를 만들고 빈으로 등록
	}
}
