package dev.syntax.step02_functional_interface;

/**
 * 단 하나의 추상 메서드만 선언된 인터페이스를 함수형 인터페이스
 *
 * 제약조건
 * 일반 인터페이스와는 다르게 함수형 인터페이스는 하나의 추상메서드만 선언해야함.
 *
 * 왜냐, int sub()가 추가되면 시그니처가 똑같아서 1:1매칭이 불가능홰짐.
 *
 * 이런 제약을 준수했는지 체크하기 위해 이 어노테이션을 사용함.
 */
@FunctionalInterface
public interface Calculator {
	int add(int a, int b);
}
