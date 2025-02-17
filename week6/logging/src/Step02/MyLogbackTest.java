package Step02;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * log4j의 취약점으로 인해 Logback 라이브러리로 변경하는 상황
 *
 * Logback 라이브러리 직접 설치 후 적용 테스트
 * 환경 설정파일도 작성
 * Logback 버전은 1.4.5버전으로
 */
public class MyLogbackTest {
	public static final Logger logger = LoggerFactory.getLogger("MyLogbackTest");

	public static void main(String[] args) {
		logger.info("abc");
	}

}
