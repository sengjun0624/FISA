package dev.service.cloud;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 커스텀 콘솔 클래스
 *
 * 사용자의 키보드 입출력을 관리하는 유틸 클래스
 */
public final class Console {
	private Console() {
	}

	private static final BufferedReader br;
	private static final BufferedWriter bw;

	static {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
	}

	public static String read() {
		try {
			return br.readLine();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static int readInt() {
		try {
			return Integer.parseInt(br.readLine());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static void print(String s) {
		try {
			bw.write(s);
			bw.flush();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static void println(String s) {
		try {
			bw.write(s);
			bw.write('\n');
			bw.flush();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static void println(Object o) {
		try {
			bw.write(o.toString());
			bw.write('\n');
			bw.flush();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public static void println() {
		try {
			bw.write('\n');
			bw.flush();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
