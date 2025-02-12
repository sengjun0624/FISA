package Step01;

import java.util.logging.Filter;
import java.util.logging.Logger;

public class Step05UsingFIlter {

	private static final Logger logger = Logger.getLogger("Step04UsingFileHandler");
	public static final Filter filter = new MyCustomFilter();
	public static void main(String[] args) {
		//info 레벨이고, 로그로 출력할 수 있는 필터링 조건. 추가적으로 로그메이지에 출력이라는 메시지만 로그로 남길 수 있도록
		logger.setFilter(filter);

		Filter newFilter = (logRecord) -> logRecord.getLevel().equals("INFO") && logRecord.getMessage().contains("출력");

		logger.info("INFO 레벨 메시지입니다"); // 이 메시지가 myfile.log라는 파일에 저장되도록
		logger.warning("warning 출력 레벨 메시지입니다"); // 이 메시지가 myfile.log라는 파일에 저장되도록
		logger.info("INFO 레벨 메출력시지입니다"); // 이 메시지가 myfile.log라는 파일에 저장되도록
		logger.info("INFO 레벨 메출시력지입니다"); // 이 메시지가 myfile.log라는 파일에 저장되도록
		logger.info("INFO 레벨 메출력지입니다"); // 이 메시지가 myfile.log라는 파일에 저장되도록
		logger.fine("fine 레벨 출력 메출력지입니다"); // 이 메시지가 myfile.log라는 파일에 저장되도록
	}

}
