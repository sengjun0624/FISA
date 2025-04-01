package dev.syntax.security.repository;

import java.util.Optional;

import dev.syntax.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // TODO: username에 해당하는 사용자를 조회하는 메서드
	Optional<User> findUserByUsername(String username);
}
