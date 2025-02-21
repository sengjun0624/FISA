package dev.syntax.step03_connection_pool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 2개 이상의 커넥션 객체를 보관, 관리를 수행하는 커넥션 풀 클래스
 *
 *
 */
public class MyConnectionPool {

	private String url; // DB 서버 URL
	private String user; // DB 서버에 접근하는 사용자 계정 이름
	private String password; // DB 서버에 접근하는 사용자 계정 비밀번호
	private static List<Connection> connectionPool; // 미리 생성할 커넥션 객체들을 보관할 리스트(커넥션 풀), 풀장
	private static List<Connection> usedConnections = new ArrayList<>(); // 사용된 커넥션 객체들
	private static int INITIAL_POOL_SIZE = 10; // 풀에 생성될 커넥션 객체 개수

	// 커넥션 풀 생성
	public static MyConnectionPool create(String url, String user, String password) throws SQLException {
		List<Connection> pool = new ArrayList<>(INITIAL_POOL_SIZE);

		// TODO: 풀 사이즈만큼 커넥션 객체 생성 로직
		for (int i = 0; i < INITIAL_POOL_SIZE; i++) {
			pool.add(createConnection(url, user, password));
		}

		return new MyConnectionPool(url, user, password, pool);
	}

	public MyConnectionPool(String url, String user, String password, List<Connection> connectionPool) {
		super();
		this.url = url;
		this.user = user;
		this.password = password;
		MyConnectionPool.connectionPool = connectionPool;
	}

	// DB 입출력에 사용할 커넥션 객체 가져오기
	public static Connection getConnection() {
		Connection connection = connectionPool.remove(connectionPool.size() - 1);
		usedConnections.add(connection);
		return connection;
	}

	// DB 입출력에 사용이 다 끝난 커넥션 객체 반납하기
	public static boolean releaseConnection(Connection connection) {
		connectionPool.add(connection);
		return usedConnections.remove(connection);
	}

	// 하나의 커넥션 객체 생성
	private static Connection createConnection(String url, String user, String password) throws SQLException {
		return DriverManager.getConnection(url, user, password);
	}

	// 현재 커넥션 개수 확인
	public int getSize() {
		return connectionPool.size() + usedConnections.size();
	}

	// 커넥션 풀 종료
	public static void shutdown() throws SQLException {
		usedConnections.forEach(MyConnectionPool::releaseConnection);
		for (Connection c : connectionPool) {
			c.close();
		}
		connectionPool.clear();
	}
}
