package com.example.sevelet_demo.step02_sevelet_process;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/process-servlet")
public class ProcessServlet extends HttpServlet {
	// 기본 생성자
	// 사용자 최초 요청 시 인스턴스가 생성됨(첫 요청 이후 브라우저를 새로고침해도 인스턴스가 재성성되지 않음)
	public ProcessServlet() {
		System.out.println("ProcessServlet() 호출됨"); // ProcessServlet 인스턴스가 생성되었다는 의미
	}

	// 일반 URL 경로(GET요청)로 요청 시 doGet() 호출
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		System.out.println("doGet() 호출됨");
	}

	// 표준 HTTP request를 public service()로부터 전달받아서 doXxx()호출
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("protected service() called");
		super.service(req, resp);
	}

	// 클라이언트의 외부 request를 protected service()에게 전달
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		System.out.println("public service() called");
		super.service(req, res);
	}
}
