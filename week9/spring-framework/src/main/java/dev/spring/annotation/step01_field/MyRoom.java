package dev.spring.annotation.step01_field;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import  dev.spring.annotation.domain.Tape;
import dev.spring.annotation.domain.TapeReader;

/**
 * XML 파일은 여전히 사용하지만, Annotation 문법이 적용되어서 보다 간소화된 설정 방식
 * step01 에서는 의존성 주입 방식으로 Field 기반으로 주입
 */
public class MyRoom {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
			"annotation-config-field.xml");
		Tape tape = context.getBean(Tape.class);
		System.out.println("tape = " + tape);

		TapeReader reader = context.getBean(TapeReader.class);
		System.out.println("reader = " + reader);

		reader.test();
	}
}
