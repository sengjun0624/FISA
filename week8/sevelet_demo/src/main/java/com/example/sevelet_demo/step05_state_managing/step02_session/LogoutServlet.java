package com.example.sevelet_demo.step05_state_managing.step02_session;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO :로그아웃 처리 로직
		/*
		 * 세션 정보를 제거
		 */
		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();

		HttpSession session = req.getSession(false);

		if (session != null && session.getAttribute("id") != null) {
			session.invalidate(); // 세션 무효화
			out.print("로그아웃 되었습니다.");
		}
		Cookie cookie = new Cookie("JSESSIONID", "");
		cookie.setPath("/");
		cookie.setMaxAge(0);
		resp.addCookie(cookie);
		out.close();
	}

}
