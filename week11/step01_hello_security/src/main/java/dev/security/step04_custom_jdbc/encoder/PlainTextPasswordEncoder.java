package dev.security.step04_custom_jdbc.encoder;

import org.springframework.security.crypto.password.PasswordEncoder;

public class PlainTextPasswordEncoder implements PasswordEncoder {

	/**
	 * 평문으로 전달받은 비밀번호를 암호화 처리하는 메서드
	 * @param rawPassword -> 사용자가 입력한 평문 비밀번호 값
	 * @return String
	 */
	@Override
	public String encode(CharSequence rawPassword) {
		return rawPassword.toString();
	}

	/**
	 * DB에 저장되어 있는 인코딩된 비밀번호 문자열 값이 사용자가 입력한 값과 일치하는지?
	 * @param rawPassword 사용자가 입력한 비밀번호 값
	 * @param encodedPassword - DB에 저장되어 있던 실제 비밀번호 값
	 * @return  return rawPassword.equals(encodedPassword);
	 */
	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return rawPassword.equals(encodedPassword);
	}
}
