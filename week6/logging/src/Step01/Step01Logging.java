package Step01;

import static java.util.logging.Logger.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Step01Logging {
	private static final Logger Logger = getLogger("Step01.Step01Logging");

	// Logger logger = new Logger();  로그의 생성과 사용둘 다 이 파일에서

	public static void main(String[] args) {
		// jul의 기본 로그레벨은 INFO
		Logger.log(Level.INFO, "INFO 레벨의 로그 메시지입니다.");
		Logger.log(Level.WARNING, "WARNING 레벨의 로그 메시지입니다.");
		Logger.log(Level.FINE, "FINE 레벨의 로그 메시지입니다.");

	}

}
