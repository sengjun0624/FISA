package com.example.sevelet_demo.step06_foward_redirect;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/redirect-servlet")
public class RedirectServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// resp.sendRedirect("") ; // 클라이언트에게 경로를 다시 요청하도록
		resp.sendRedirect("page1");
	}
}
