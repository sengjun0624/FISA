package dev.spring.component_scan.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// TapeReader 클래스를 스프링의 컴포넌트 스캔 대상이 되도록 지정
// 해당 클래스는 애플리케이션에서 활용할 비즈니스 객체인 빈으로 등록하도록 선언,정의
// 결과적으로 해당 클래스를 스프링 컨테이너가 관리할 하나의 Bean으로 생성, 관리하도록 설정함
@Component
public class TapeReader {

	private Tape tape;

	public TapeReader(Tape tape) {
		this.tape = tape;
	}

	public void test() {
		if (tape.isWorked()) {
			System.out.println(tape.getName() + " 잘 동작합니다");
		} else {
			System.out.println(tape.getName() + " 사기당했어요 ㅋㅋ");
		}
	}
}
