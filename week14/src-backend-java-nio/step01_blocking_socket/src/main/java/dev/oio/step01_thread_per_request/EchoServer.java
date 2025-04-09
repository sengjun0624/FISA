package dev.oio.step01_thread_per_request;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class EchoServer {
    public static boolean isClientConnected = false; // 클라이언트 연결 상태

    public static void main(String[] args) {
        int port = 12345; // 서버 포트
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("서버가 시작되었습니다. 포트: " + port);
            while (true) {
                    Socket clientSocket = serverSocket.accept();
                    isClientConnected = true; // 클라이언트 연결 상태 설정
                    System.out.println("클라이언트 연결: " + clientSocket.getInetAddress());

                    // 클라이언트와의 통신을 위한 스레드 생성
                    new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler extends Thread {
    private Socket clientSocket;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        System.out.println("클라이언트 스레드 ID: " + Thread.currentThread().getId()); // 스레드 ID 출력

        try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("클라이언트 스레드 ID: " + Thread.currentThread().getId() + " 클라이언트로부터 수신: " + inputLine);
                out.println(inputLine); // 클라이언트에게 에코
            }
        } catch (SocketException e) {
            System.out.println("클라이언트가 연결을 종료했습니다.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
                System.out.println("클라이언트 연결 종료: " + clientSocket.getInetAddress());
                EchoServer.isClientConnected = false; // 연결 종료 시 상태 변경
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


