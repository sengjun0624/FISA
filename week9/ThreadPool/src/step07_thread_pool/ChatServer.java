package step07_thread_pool;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ChatServer {
	private static final ThreadPool threadPool = new ThreadPool();

	public static void main(String[] args) {
		try {
			ServerSocket serverSocket = new ServerSocket(5555);
			System.out.println("서버가 시작되었습니다. 클라이언트를 기다립니다.");

			while (true) {
				Socket socket = serverSocket.accept();
				System.out.println("클라이언트가 연결됨: " + socket.getInetAddress());
				threadPool.put(new ClientHandler(socket));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}
}

// 클라이언트별 통신을 담당하는 스레드 클래스
class ClientHandler implements Runnable {
	private Socket socket;

	public ClientHandler(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			InputStream in = socket.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(in);
			OutputStream out = socket.getOutputStream();
			OutputStreamWriter outputStreamReader = new OutputStreamWriter(out);

			while (true) {
				int request = inputStreamReader.read();
				if (request == -1) break; // 클라이언트가 연결 종료하면 루프 종료
				// System.out.println("클라이언트 " + socket.getInetAddress() + " 요청: " + request);
				outputStreamReader.write(request);
				outputStreamReader.flush();
			}

			System.out.println("클라이언트 연결 종료: " + socket.getInetAddress());
			socket.close(); // 소켓 닫기
		} catch (IOException e) {
			System.out.println("클라이언트 통신 오류: " + e.getMessage());
		}
	}
}
