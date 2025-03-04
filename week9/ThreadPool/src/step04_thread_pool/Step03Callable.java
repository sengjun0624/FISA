package step04_thread_pool;

import java.util.concurrent.Callable;

public class Step03Callable {

	public static void main(String[] args) {
		try {
			Callable<String> callable = () -> {
				return "Callable 작업 결과";
			};
			System.out.println(callable.call());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
