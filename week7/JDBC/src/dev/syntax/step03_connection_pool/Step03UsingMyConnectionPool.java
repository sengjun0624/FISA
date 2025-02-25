package dev.syntax.step03_connection_pool;

import java.sql.Connection;
import java.sql.SQLException;

public class Step03UsingMyConnectionPool {
	public static void main(String[] args) {
		final String URL = "jdbc:mysql://localhost:3306/";
		final String DATABASE_NAME = "testdb";
		final String USER = "root";
		final String PASSWORD = "Tmdwns0624@";

		try {
			MyConnectionPool.create(URL + DATABASE_NAME, USER, PASSWORD);
			Connection connection1 = MyConnectionPool.getConnection();
			Connection connection2 = MyConnectionPool.getConnection();

			System.out.println(connection1);
			System.out.println(connection2);
			// 3. 각 클라이언트들은 할당받은 커넥션 객체를 통해 DB입출력 처리를 수행했다고 가정

			// 4. 입출력 처리가 완료되었을 경우에는 relaseConnection()으로 커넥션 반납
			MyConnectionPool.releaseConnection(connection1);

			// 5. 프로그램 종료 전에는 shutdown() 호출(내부적으로 알아서 함)
			MyConnectionPool.shutdown();
		} catch (SQLException e) {

		}
	}

}
