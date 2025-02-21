package cloud;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/*
 * 설정 파일 외부화
 * -> java.util 패키지에서 제공하는 Properties 클래스 활용
 *
 * jdbc.properties라는 파일을 생성 후
 * 해당 파일 내에 DB 서버 연결과 관련된 설정 정보를 작성하기(key=value 형태로)
 */
public class DBUtil {

	public static Connection getConnection(String argument) {
		// argument - 커맨드 라인으로 입력받은 파일 이름(ex. jdbc.properties)

		try {
			// 외부 라이브러리 불러오기
			Properties prop = DBConfigurer.readProperties(argument);

			final String USER_NAME = prop.getProperty("USER_NAME");
			final String PASSWORD = prop.getProperty("PASSWORD");
			final String DB_URL = prop.getProperty("DB_URL");
			final String DATABASE = prop.getProperty("DATABASE");

			Connection connection = DriverManager.getConnection(DB_URL + DATABASE, USER_NAME, PASSWORD);
			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


}
