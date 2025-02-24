package dev.pool.config;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
/**
 * HikariCP 기반 DataSource를 통해 커넥션 풀을 생성하기 위한 래퍼(Wrapper) 클래스
 */
public class HikariCPDataSource {

	private static HikariConfig config = new HikariConfig(); // HikariCP의 설정 정보를 갱신
	private static HikariDataSource dataSource; // 커넥션 풀을 생성해주는 클래스

	private static final String RESOURCES = "src/main/resources/";

	// Step01일 경우 V1 사용, Step02면 V2 사용
	private static final String scenario_V1 = "hikari.propertiesV1";
	private static final String scenario_V2 = "hikari.propertiesV2";
	private static final String scenario_V3 = "hikari.propertiesV3";
	static { // static 블록, 애플리케이션이 시작될 때 먼저 실행되는 코드 블록(프로그램 실행 시 미리 동작하도록 하기 위해)
		Properties properties = new Properties();
		try (FileInputStream fis
				 = new FileInputStream(RESOURCES + scenario_V2)) {
			properties.load(fis);
			// 필수 설정값 적용
			config.setJdbcUrl(properties.getProperty("jdbcUrl"));
			config.setUsername(properties.getProperty("username"));
			config.setPassword(properties.getProperty("password"));
			// HikariCP 설정 적용
			for (String key : properties.stringPropertyNames()) {
				String value = properties.getProperty(key);
				value = value.split("#")[0].trim();
				switch (key) {
					case "maximumPoolSize":
						System.out.println(value);
						config.setMaximumPoolSize(Integer.parseInt(value));
						break;
					case "minimumIdle":
						config.setMinimumIdle(Integer.parseInt(value));
						break;
					case "connectionTimeout":
						config.setConnectionTimeout(Long.parseLong(value));
						break;
					case "idleTimeout":
						config.setIdleTimeout(Long.parseLong(value));
						break;
					case "keepaliveTime":
						config.setKeepaliveTime(Long.parseLong(value));
						break;
					case "maxLifetime":
						config.setMaxLifetime(Long.parseLong(value));
						break;
					default:
						config.addDataSourceProperty(key, value);
						break;
				}
			}
			printConfigProperties(config);
		} catch (IOException e) {
			throw new RuntimeException("Failed to load hikari.properties", e);
		}
		dataSource = new HikariDataSource(config);
	}
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}
	private HikariCPDataSource() {
	}
	public static void printConfigProperties(HikariConfig config) {
		System.out.println();
		System.out.println("HikariCP 설정 정보");
		System.out.printf("Maximum Pool Size: %d (최대 커넥션 개수)%n", config.getMaximumPoolSize());
		System.out.printf("Minimum Idle: %d (최소 유휴 커넥션 개수)%n", config.getMinimumIdle());
		System.out.printf("Connection Timeout: %d ms (커넥션 할당 만료시간)%n", config.getConnectionTimeout());
		System.out.printf("Idle Timeout: %d ms (유휴 만료시간)%n", config.getIdleTimeout());
		System.out.printf("Keepalive Time: %d ms (Keepalive 만료시간)%n", config.getKeepaliveTime());
		System.out.printf("Max Lifetime: %d ms (최대 수명주기)%n", config.getMaxLifetime());
		System.out.println();
	}
}
