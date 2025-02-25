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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//TODO: 로그인 처리 로직
		// HttpSession 클래스, Cookie를 활용
		/*
		 * 로그인이 완료되었을 경우, "로그인 완료"라는 문자열 응답(PrintWriter 활용)
		 * 이미 로그인된 상태일 경우, "현재 로그인 상태입니다."라는 문자열 응답
		 * 아이디나 비밀번호 중에 하나라도 공백이 있으면 "아이디 및 비밀번호를 입력해주세요"
		 */

		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();

		String id = req.getParameter("id");
		String password = req.getParameter("password");

		if (id.isEmpty() || password.isEmpty()) {
			out.print("아이디 혹은 비밀번호를 입력하세요");
			return;
		}

		// ID/PW 확인이 완료되었다고 가정

		// 로그인한 회원 정보를 구분할 수 있는 key값을 보관할 세션 객체 생성
		HttpSession session = req.getSession();

		System.out.println(session.getId()); // 쿠키에 "JSESSIONID"라는 key로 추가된 실제 value

		// 세션 객체가 처음 생성된 세션이고, id 프로퍼티의 값이 null일 경우
		if (session.isNew() || session.getAttribute("id") == null) {
			session.setAttribute("id", id);
			out.print("로그인 완료");
		}
		out.close();
	}

}
