package Step01;

import java.util.logging.Handler;
import java.util.logging.Logger;

public class Step03UsingHandler {
	public static final Logger logger = Logger.getLogger("Step03usingHandler");

	public static void main(String[] args) {
		// default는 콘솔 핸들러이다.
		// 객제치향의 장점: 필요에 따라 직접 핸들러를 생성, 등록해서 사용할 수도 있음

		// 커스텀 핸들러 사용
		Handler handler = new MyCustomHandler();

		logger.addHandler(handler);

		logger.info("INFO 레벨 메시지입니다.");

	}
}
