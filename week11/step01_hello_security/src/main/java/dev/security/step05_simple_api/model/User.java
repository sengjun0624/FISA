package dev.security.step05_simple_api.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;

/**
 * DB에 저장할 사용자 정보 테이블
 */
@Entity
@Getter
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String username;
	private String password;

	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private List<Authority> authorities;

	/**
	 * 비밀번호 인코딩 처리
	 * @param encodedPassword
	 */
	public void encodePassword(String encodedPassword){
		this.password = encodedPassword;
	}
}
