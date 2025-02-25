package com.example.sevelet_demo.step01_hello_servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * 1. 서블릿이란?
 * 서버에서 실행되는 자바 프로그램
 *
 * 2. 작성 방법
 * 2-1. HttpServlet 클래스를 확장(extends)
 * -> HTTP요청에 따른 처리 로직이 구현되어 있기 떄문에
 * doGet() -> Get 요청
 * doPost() -> Post 요청
 */
public class FirstServlet extends HttpServlet {
	private String message;

	public void init() {
		message = "Hello World!";
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");

		// Hello
		PrintWriter out = resp.getWriter();
		out.println("<html><body>");
		out.println("<h1>" + message + "</h1>");
		out.println("</body></html>");
	}
}
