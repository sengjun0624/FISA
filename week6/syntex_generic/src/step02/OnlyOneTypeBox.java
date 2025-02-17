package step02;

/**
 * 단 하나의 타입만 받을 수 있는 박스 클래스
 *
 * <T> - 타입 파라미터 T는 별칭같은 개념으로, T가 Apple이 될 수도 있고, Banana가 될 수도 있음
 */
public class OnlyOneTypeBox<T> {
	private T t;  //private Apple apple;

	public T get() {
		return t;
	}

	public void set(T t) {
		this.t = t;
	}
}
