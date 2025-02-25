package dev.pool;

import static org.slf4j.LoggerFactory.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dev.pool.config.HikariCPDataSource;
/**
 * 자체 생성한 커넥션 풀이 아닌 상용 라이브러리인 HikariCP를 적용
 *
 * 외부 커넥션 풀 라이브러리를 기반으로 커넥션 풀을 생성하기 위해서는 DataSource 인터페이스를 활용|
 */
public class Step01HikariPool {
	public static final Logger logger = getLogger(Step01HikariPool.class);

	public static void main(String[] args) throws SQLException {

		// 커넥션 풀에서 커넥션 객체 1개 할당받음
		Connection connection = HikariCPDataSource.getConnection();
		// -> 풀에서 커넥션 객체를 하나 꺼냈기 때문에 active는 1
		// HikariPool-1 - After adding stats (total=10, active=1, idle=9, waiting=0)

		logger.info("connection={}", connection);

		while (true) {

		}

		// show processlist;로 풀 생성 개수 확인
		//
	}
}
