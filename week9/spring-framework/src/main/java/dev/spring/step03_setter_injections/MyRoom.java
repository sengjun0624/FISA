package dev.spring.step03_setter_injections;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dev.spring.domain.Tape;
import dev.spring.domain.TapeReader;

public class MyRoom {

	public static void main(String[] args) {

		// 스프링 컨테이너 객체 생성
		ApplicationContext context = new ClassPathXmlApplicationContext("setter-config.xml");

		// 생성한 스프링 컨테이너 객체가 설정 파일을 읽도록 지정
		TapeReader reader = context.getBean(TapeReader.class);
		System.out.println("reader = " + reader);


		// TODO: Tape에 대한 의존성도 설정 정보에 작성해서, 세터 주입 작성해보기
		Tape tape = context.getBean(Tape.class);

		// 설정 파일을 읽은 스프링 컨테이너를 통해 필요한 빈을 가져오기
		reader.test();
	}
}
