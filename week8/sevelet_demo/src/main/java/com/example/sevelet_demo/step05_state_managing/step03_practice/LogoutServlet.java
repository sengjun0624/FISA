package com.example.sevelet_demo.step05_state_managing.step03_practice;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/practice-logout")
public class LogoutServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
		// 기존 세션이 있다면 무효화
		HttpSession session = req.getSession(false);
		if (session != null) {
			session.invalidate();
		}

		// 로그아웃 완료 메시지 출력
		resp.setContentType("text/html;charset=UTF-8");
		Cookie cookie = new Cookie("JSESSIONID", "");
		cookie.setPath("/");
		cookie.setMaxAge(0);
		resp.addCookie(cookie);
		resp.sendRedirect("index2.html");
	}
}
