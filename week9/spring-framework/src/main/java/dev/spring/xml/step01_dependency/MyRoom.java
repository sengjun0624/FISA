package dev.spring.xml.step01_dependency;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dev.spring.xml.domain.Tape;
import dev.spring.xml.domain.TapeReader;

/**
 * 내 방
 *
 * 비디오 테이프를 빌렸는데, 내 방에서 Tape(.java)가 잘 돌아가는지 테스트
 * 테스트는 비디오 테스트 기기인 TapeReader(.java)를 통해 수행할 수 있음
 */
public class MyRoom {
	public static void main(String[] args) {
		ApplicationContext context
			= new ClassPathXmlApplicationContext("factory-config.xml");
		TapeReader reader = context.getBean(TapeReader.class);
		reader.test();

	}
}
