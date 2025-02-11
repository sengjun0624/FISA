import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class Step04UsingFIleHandler {
	public static final Logger logger = Logger.getLogger("Step04");

	public static void main(String[] args){
		try {
			logger.addHandler(new FileHandler("myfile.log"));

		} catch (IOException | SecurityException e) {
			e.printStackTrace();
		}
		logger.info("INFO 레벨 메시지입니다.");
	}
}
