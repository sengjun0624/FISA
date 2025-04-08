package dev.oio.step02_thread_pooling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoClient {
    public static void main(String[] args) {
        String serverAddress = "localhost"; // 서버 주소
        int port = 12345; // 서버 포트

        try {
            // 서버에 연결 시도
            Socket socket = new Socket(serverAddress, port);
            System.out.println("서버에 연결되었습니다."); // 연결 성공 시 메시지 출력

            try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                 BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {

                String userInput;
                while ((userInput = stdIn.readLine()) != null) {
                    out.println(userInput); // 서버로 메시지 전송
                    System.out.println("서버로부터 수신: " + in.readLine()); // 서버로부터 에코 수신
                }
            }
        } catch (UnknownHostException e) {
            System.out.println("서버를 찾을 수 없습니다: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("서버에 연결 대기 중입니다."); // 연결 실패 시 대기 중 메시지 출력
            e.printStackTrace();
        }
    }
}