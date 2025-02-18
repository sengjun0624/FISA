package dev.syntax.step05mutex;


/**
 * synchronized라는 Java에서 제공하는 키워드를 사용하지 않고,
 * Mutex라는 직접 작성한 래퍼(Wrapper) 클래스를 통해 의사 코드로 동기화 기법을 구현
 */
public class Main {

	public static void main(String[] args) throws InterruptedException {
		// 공유 데이터를 가진 클래스 SharedData 생성 - 동기화 기법 확인용 클래스
		SharedData sharedData = new SharedData(new Mutex());

		// 스레드 2개 생성
		// 스레에게 각각 sum() 작업을 수행하도록 지정
		Thread t1 = new Thread(sharedData::sum);
		Thread t2 = new Thread(sharedData::sum);

		// 실행
		t1.start();
		t2.start();

		t1.join();
		t2.join();

		// 최종 합계 확인
		System.out.println("최종 합계: " + sharedData.getSum());
	}

}
