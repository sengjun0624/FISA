package com.example.sevelet_demo.step03_http_request;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/first-response-servlet")
public class FirstHttpResponseServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws
		ServletException,
		IOException {

		// 응답할 컨텐츠의 타입, 인코딩 타입 등을 명시
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		// 커스텀 응답 메시지 작성
		response.setHeader("custom-header","커스텀 응답 메시지");


		PrintWriter out = response.getWriter();

		// <html></html> 생략
		out.print("Hello");
		out.close();

	}


}
