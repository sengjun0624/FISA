package dev.spring.annotation.step03_constructor;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import dev.spring.annotation.domain.Tape;
import dev.spring.annotation.domain.TapeReader;

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
