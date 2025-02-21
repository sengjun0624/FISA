import static dev.syntax.step02todo.util.DBUtil.*;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 설정 파일 외부화
 *
 * jdbs.properties라는 파일을 생성 후
 * 해당 파일 내에 DB 서버 연결과 관련된 설정 정보를 작성하기 (key= value) 형태로
 */
public class Main {
	public static void main(String[] args) throws SQLException {
		Connection connection = getConnection();

		System.out.println("Hello world!");
	}
}
