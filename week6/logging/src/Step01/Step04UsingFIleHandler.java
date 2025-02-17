package Step01;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Step04UsingFIleHandler {

	private static final Logger logger = Logger.getLogger("Step04UsingFileHandler");

	public static void main(String[] args) {

		try {
			Handler fileHandler = new FileHandler("myfile.log");

			// XML에서 사람이 읽기 쉬운 포매팅으로 변경
			Formatter logFormatter = new SimpleFormatter();
			fileHandler.setFormatter(logFormatter); // 파일 핸들러에게 포매터 등록

			logger.addHandler(fileHandler);
		} catch (SecurityException | IOException e) {
			e.printStackTrace();
		}

		logger.info("INFO 레벨 메시지입니다"); // 이 메시지가 myfile.log라는 파일에 저장되도록

	}
}
