package dev.pool;

import static org.slf4j.LoggerFactory.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;

import dev.pool.config.HikariCPDataSource;

// 커넥션 풀에 생성된 커넥션들이 모두 사용중일 경우
// 새로운 커넥션 할당 요청이 들어왔을 때, connectionTimeout(최대 대기할 수 있는 시간)을 초과하면
// SQL Exception이 발생ㄹ한다.
public class Step02ConnectionPool {
	public static final Logger logger = getLogger(Step01HikariPool.class);

	public static void main(String[] args) throws SQLException {
		for (int i = 1; i <= 5 ; i++) {
			HikariCPDataSource.getConnection(); // 5개가 사용 중
		}

		HikariCPDataSource.getConnection(); // 6번째 커넥션 할당 요청, 5초 대기 후 ConnectionTimeout으로 인한 다음의 예외 발생
		// Exception in thread "main" java.sql.SQLTransientConnectionException: HikariPool-1 - Connection is not available, request timed out after 5001ms.

		while (true) {}
	}
}
