package Step01;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Step02ConfigLevel {
	// Logger 객체 생성
	private static final Logger logger = Logger.getLogger("Step01.Step02ConfigLevel");

	public static void main(String[] args) {

		Logger rootLog = Logger.getLogger("");
		rootLog.setLevel(Level.FINE);
		rootLog.getHandlers()[0].setLevel(Level.FINE);

		logger.setLevel(Level.FINE);

		logger.log(Level.INFO, "INFO 레벨의 로그 메시지 입니다.");

		logger.log(Level.WARNING, "WARNING 레벨의 로그 메시지 입니다.");

		logger.log(Level.FINE, "FINE 레벨의 로그 메시지입니다");
	}

}
