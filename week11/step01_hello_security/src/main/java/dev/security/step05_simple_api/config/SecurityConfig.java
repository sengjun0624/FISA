package dev.security.step05_simple_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity(debug = true)
public class SecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		http.formLogin()
			.defaultSuccessUrl("/products", true)
			.loginPage("/login") // 커스텀 로그인 페이지에 대한 URI 경로 지정
			.permitAll(); // 로그인 페이지는 누구나 접근할 수 있도록 지정

		// // 루트 경로에 대해서는 별도의 인증 없이 접근 허용(permitAll())
		// http.authorizeRequests()
		// 	.mvcMatchers("/","/signup") // 루트 경로에 대해서는
		// 	.permitAll(); // 별도의 인증 없이 접근 허용

		http
			.authorizeHttpRequests((authorize) -> authorize
				.antMatchers("/products").hasAuthority("USER")
				.anyRequest().authenticated()
			);



		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

}
