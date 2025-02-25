package com.example.sevelet_demo.step01_hello_servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * 2. Annotaion(@) 기반 서블릿 맵핑
 * XML을 통한 관리 방식의 번거로움, 복잡함
 * 추상화되고 직관적인 어노테이션으로 간소화
 */
@WebServlet(name = "MySecondServlet",urlPatterns = "/second-servlet")
public class SecondServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Hello Second Servlet");
	}
}
