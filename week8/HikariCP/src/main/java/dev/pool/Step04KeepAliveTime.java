package dev.pool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;

import dev.pool.config.HikariCPDataSource;

public class Step04KeepAliveTime {

	public static void main(String[] args) throws InterruptedException, SQLException {

		// 초기 커넥션 1개 요청
		System.out.println("연결 객체 A 생성");
		Connection connection1 = HikariCPDataSource.getConnection(); // 커넥션 풀에 1번째 커넥션 할당 요청

		System.out.println("6분대기");
		TimeUnit.MINUTES.sleep(6);  // 네트워크 타임아웃(5분) 초과
		// After adding stats (total=4, active=1, idle=3, waiting=0)
		try {
			System.out.println("🔍 7분: 기존 커넥션 사용 시도...");
			connection1.prepareStatement("SELECT 1").executeQuery();
		} catch (SQLException e) {
			System.err.println("❌ 7분: 커넥션 사용 실패! (네트워크에서 이미 종료됨)");
			e.printStackTrace();
		}
		// 4. 10분이 지나면서 HikariCP가 keepalive 실행
		System.out.println("⏳ 10분 대기 중 (keepalive 실행 예상)");
		TimeUnit.MINUTES.sleep(4);  // 10분까지 대기

		// 5. 새로운 커넥션 시도
		Connection conn2 = null;
		try {
			conn2 = HikariCPDataSource.getConnection();
			System.out.println("✅ 10분: 새로운 커넥션 생성 완료");
		} catch (SQLException e) {
			System.err.println("❌ 10분: 커넥션 생성 실패");
		}

		conn2.close();
	}

}
