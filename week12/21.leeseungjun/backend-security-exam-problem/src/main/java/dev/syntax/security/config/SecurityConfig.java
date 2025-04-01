package dev.syntax.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import dev.syntax.security.service.JpaUserDetailsService;
import lombok.RequiredArgsConstructor;

// 스프링 시큐리티에서 사용할 스프링 빈을 설정하는 빈 설정 정보 파일
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.formLogin()
            .defaultSuccessUrl("/users/profile", true)
            .loginPage("/login") // 커스텀 로그인 페이지 설정
            .permitAll(); // 로그인 페이지는 누구나 접근 가능

        http.authorizeRequests()
            .mvcMatchers("/users").hasRole("ADMIN")
            .mvcMatchers("/**").permitAll()
            .anyRequest().authenticated(); // 그 외 모든 요청은 인증 필요
        return http.build();
    }


    // 시큐리티에서 제공하는 BCryptEncoder(비밀번호 인코더)를 빈으로 등록
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
