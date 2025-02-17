package dev.syntax.step04multithread;

import java.io.OutputStream;
import java.io.PrintStream;

/**
 * PrintStream 클래스를 상속한 서브 클래스
 */
public class CustomPrintStream extends PrintStream {
	// 생성자
	public CustomPrintStream(OutputStream out, boolean autoFlush) {
		super(out, autoFlush);
	}

	@Override
	public void println(boolean x) {
		//임계역역으로 지정, 한 시점에 하나의 스레드만 접근할 수 있는 임계 영역으로 지정
		synchronized (this){
			print(x);
			newLine();
		}

	}

	private void newLine() {
		print("\n");
	}
	@Override
	public void print(boolean x) {
		super.print(x);
	}

}
