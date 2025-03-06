package dev.spring.xml.step05_factory_injections;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import dev.spring.xml.domain.TapeReader;

public class MyRoom {
	public static void main(String[] args) {
		ApplicationContext context
			= new ClassPathXmlApplicationContext("factory-config.xml");
		TapeReader reader = context.getBean(TapeReader.class);
		reader.test();

	}
}
