package dev.spring.xml.step04_constructor_injections;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dev.spring.xml.domain.Tape;
import dev.spring.xml.domain.TapeReader;

public class MyRoom {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("constructor-config.xml");

		TapeReader reader = context.getBean(TapeReader.class);
		reader.test();

		Tape tape = context.getBean(Tape.class);
		reader.test();
	}
}
