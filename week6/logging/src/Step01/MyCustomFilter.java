package Step01;

import java.util.logging.Filter;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class MyCustomFilter implements Filter {
	@Override
	public boolean isLoggable(LogRecord record) {
		Level level = record.getLevel();
		String message = record.getMessage();
		return level.intValue() >= Level.INFO.intValue() && message.contains("출력");
	}

}
