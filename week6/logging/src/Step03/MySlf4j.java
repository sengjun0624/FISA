package Step03;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * 현재 Slf4j API 의존성이 설치되어 있고,
 * Log4j, Logback 라이브러리 구현체에 대한 의존성도 설치되어 있음
 *
 * 현재 사용 중인 구현체는 무엇인지 확인?
 * 만약 Logback을 사용 중이라고 하면, Log4j로 다시 바꿀 수도 있어야 함
 *
 * 현재로는 하나의 구현체만 적용하려면 logback과 log4j 중 사용하지 않는 의존성은 클래스패스에서 제거
 * 과제: log4j를 slf4j를 통해서 사용하려면 지금 의존성만으로는 실행 안됨
 * -> Log4j를 사용하되, SLF4j를 통해서 사용할 수 있도록 적용
 */
public class MySlf4j {
	public static Logger log = LoggerFactory.getLogger("MySlf4j");

	public static void main(String[] args) {
		log.info("INFO message");
	}
}
