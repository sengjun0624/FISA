package step05_socket_basic;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleSimpleServer {
	public static void main(String[] args) throws Exception {

		ServerSocket serverSocket = new ServerSocket(5555);
		System.out.println("서버가 시작되었습니다. 클라이언트를 기다립니다.");

		Socket socket = serverSocket.accept();
		System.out.println("클라이언트가 연결됨");

	}
}
