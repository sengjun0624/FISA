package com.example.sevelet_demo.step03_http_request;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/first-request-servlet")
public class FirstHttpRequestServlet extends HttpServlet {

	/**
	 * HTTPServletRequest
	 * 네크워트를 통해 전송되는 HTTP 요청 정보를 활용하기 위해 자바에서 추상화 해놓은 클래스
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 응답할 컨텐츠의 타입, 인코딩 타입 등을 명시
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");

		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<head>");
		out.println("<title>Request Information Example</title>");
		out.println("</head>");

		out.println("<body>");

		out.println("<h3>요청 메시지에 담긴 정보 확인</h3>");

		// Header 메시지에 담긴 정보 추출
		out.println("Context Path : " + request.getContextPath() + "<br/>");
		out.println("Request URL : " + request.getRequestURL() + "<br/>");
		out.println("Request URI : " + request.getRequestURI() + "<br/>");
		out.println("Server Port : " + request.getServerPort() + "<br/>");
		out.println("Request Protocol : " + request.getProtocol() + "<br/>");
		out.println("Request METHOD: " + request.getMethod() + "<br/>");
		out.println("Query String : " + request.getQueryString() + "<br/>");// http://localhost:8080/step10newsyntax/first-request-servlet?name=jerry&age=15
		out.println("Parameter(name) : " + request.getParameter("name") + "<br/>");
		out.println("Parameter(age) : " + request.getParameter("age") + "<br/>");

		out.println("</body>");
		out.println("</html>");

		out.close();
	}

}
