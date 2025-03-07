package dev.spring.config.config;

import org.springframework.context.annotation.Bean;

import dev.spring.config.domain.Tape;
import dev.spring.config.domain.TapeReader;


// Bean에 대한 설정 정보를 class 내에 정의
public class BeanConfig {

	@Bean
	public TapeReader tapeReader(Tape tape){
		return new TapeReader(tape);
	}

	@Bean
	public Tape tape(){
		return new Tape("아일랜드", true);
	}
}
