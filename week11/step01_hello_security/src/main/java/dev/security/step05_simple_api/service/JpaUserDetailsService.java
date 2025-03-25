package dev.security.step05_simple_api.service;


import dev.security.step05_simple_api.model.User;
import dev.security.step05_simple_api.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

// UserDetailsService 인터페이스를 구현한 커스텀 구현체
// JPA를 통해 사용자 정보를 DB에서 조회할 수 있도록 구현
@Service // 시큐리티가 활용할 수 있도록 빈으로 등록
@RequiredArgsConstructor
public class JpaUserDetailsService implements UserDetailsService {

	private final UserRepository userRepository;

	/**
	 * DB에서 사용자 정보 조회, 전달받은 username에 해당하는 사용자만 조회
	 * @param username
	 * @return
	 * @throws UsernameNotFoundException
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO: 개발자가 작성한 JPA를 통해 DB에서 조회하는 로직 작성 부분

		// TODO: 1. DB에서 사용자 조회
		User user = userRepository.findUserByUsername(username)
			.orElseThrow(() -> new UsernameNotFoundException("해당하는 user가 없음"));
		System.out.println("user = " + user);

		// TODO: 2. 반환타입이 DB에서 꺼낸 Entity인 User가 아닌 시큐리티에서 사용하는 UserDetails이기 때문에 해당 타입으로 감싸주는 처리

		// CustomUserDetails의 인수로 User Entity를 전달
		CustomUserDetails customUserDetails = new CustomUserDetails(user);
		return customUserDetails;
	}
}
