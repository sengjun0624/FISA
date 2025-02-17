package dev.syntax.step03threadapi;

public class Ex01Sleep {
	public static void main(String[] args) {
		try {
			Thread.sleep(1000);
			System.out.println("1초후 출력");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
