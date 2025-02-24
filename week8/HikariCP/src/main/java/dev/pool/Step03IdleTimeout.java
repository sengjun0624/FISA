package dev.pool;

import java.sql.Connection;
import java.sql.SQLException;

import dev.pool.config.HikariCPDataSource;

/**
 * IdleTimeout 옵션 테스트 시나리오
 *
 * 커넥션 풀에 생성된 커넥션 객체들 중에서 사용되지 않고 있는 객체들은 유휴 상태(Idle)
 *
 * 풀에 현재 5개의 커넥션 객체가 있는데, 만약 실제로 사용되는 건 1개밖에 없을 경우, 4개가 유휴 상태
 * minimumIdle(유휴 커넥션 객체를 최소로 유지할 개수)
 *
 * 이 값대로 유휴 커넥션 개수가 유지되는지 확인
 *
 */
public class Step03IdleTimeout {

	public static void main(String[] args) throws InterruptedException, SQLException {

		// 초기 커넥션 1개 요청
		System.out.println("10초 경과 전..");
		Connection connection1 =  HikariCPDataSource.getConnection(); // 커넥션 풀에 1번째 커넥션 할당 요청
		// After cleanup  stats (total=1, active=1, idle=0, waiting=0)

		// 10초 동안 아무것도 안할 때는 최소 유휴 커넥션이 3개로 유지되기 때문에 사용 중인 커넥션을 포함하여 총 4개가 생성되어 있음
		Thread.sleep(10000);
		// After adding stats (total=4, active=1, idle=3, waiting=0)

		// 10초 후 4개를 추가 요청할 경우, 2개를 추가적으로 더 생성하여 5개가 사용됨
		System.out.println("10초 후..");
		Connection connection2 =  HikariCPDataSource.getConnection(); // 2번째 커넥션 할당 요청
		Connection connection3 =  HikariCPDataSource.getConnection(); // 3번째 커넥션 할당 요청
		Connection connection4 =  HikariCPDataSource.getConnection(); // 4번째 커넥션 할당 요청
		Connection connection5 =  HikariCPDataSource.getConnection(); // 5번째 커넥션 할당 요청

		// 약 10초 후 2개를 사용하지 않고 유휴 상태로 두면, 다시 최소 커넥션인 3개로 유지됨
		Thread.sleep(10000);
		System.out.println("10초 후.. 2개 반납");
		connection4.close(); // Releases this Connection object
		connection5.close(); // Releases this Connection object

		//		// 10초 이상 아무 요청도 보내지 않음, idleTimeout인 5초 경과 후 5개였던 커넥션이 2개 제거되어 다시 3개로 유지됨
		while (true) {}
		/*
		 * 2025-02-22 13:31:12 DEBUG com.zaxxer.hikari.pool.HikariPool - HikariPool-1 - Before cleanup stats (total=8, active=3, idle=5, waiting=0)
2025-02-22 13:31:12 DEBUG com.zaxxer.hikari.pool.HikariPool - HikariPool-1 - After cleanup  stats (total=6, active=3, idle=3, waiting=0)
2025-02-22 13:31:12 DEBUG com.zaxxer.hikari.pool.HikariPool - HikariPool-1 - Fill pool skipped, pool has sufficient level or currently being filled (queueDepth=0).
2025-02-22 13:31:12 DEBUG com.zaxxer.hikari.pool.PoolBase - HikariPool-1 - Closing connection com.mysql.cj.jdbc.ConnectionImpl@1585a214: (connection has passed idleTimeout)
2025-02-22 13:31:12 DEBUG com.zaxxer.hikari.pool.PoolBase - HikariPool-1 - Closing connection com.mysql.cj.jdbc.ConnectionImpl@4495edab: (connection has passed idleTimeout)
2025-02-22 13:31:42 DEBUG com.zaxxer.hikari.pool.HikariPool - HikariPool-1 - Before cleanup stats (total=6, active=3, idle=3, waiting=0)
2025-02-22 13:31:42 DEBUG com.zaxxer.hikari.pool.HikariPool - HikariPool-1 - After cleanup  stats (total=6, active=3, idle=3, waiting=0)
		 */

	}

}
