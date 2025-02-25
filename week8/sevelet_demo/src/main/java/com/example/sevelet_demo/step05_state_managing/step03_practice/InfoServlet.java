package com.example.sevelet_demo.step05_state_managing.step03_practice;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/info")
public class InfoServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 기존 세션을 가져오고, 세션이 없거나 "id" 속성이 없으면 index.html로 리다이렉트
		HttpSession session = req.getSession(false);
		if (session == null || session.getAttribute("id") == null) {
			resp.sendRedirect("index.html");
			return;
		}

		// 세션이 존재하면 보호된 페이지 내용 출력
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter writer = resp.getWriter();
		writer.print("보호된 페이지입니다.");
		writer.close();
	}
}
