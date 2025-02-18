package dev.syntax.step05mutex;

public class SharedData {
	private long sharedValue = 0;
	private Mutex mutex;

	public SharedData(Mutex mutex) {
		this.mutex = mutex;
	}

	public void sum() {
		// sum이라는 영역이 임계영역으로서 처리가 되어야하는 상황
		// 특정 쓰레드가 락을 휙득 해야함.
		mutex.acquired();
		for (int i = 1; i <= 1000000; i++) {
			sharedValue ++;
		}
		mutex.release();
		// lock을 해제해야 다른 쓰레드가 작업을 수행할 수 있다.
	}
	public long getSum(){
		return sharedValue;
	}

}
