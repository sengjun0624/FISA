package com.example.sevelet_demo.step05_state_managing.step03_practice;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/practice-register")
public class RegisterServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws
		ServletException,
		IOException,
		UnsupportedEncodingException {
		// 한글 처리
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");

		PrintWriter out = resp.getWriter();

		// 1) 파라미터 받기
		String id = req.getParameter("id");
		String password = req.getParameter("password");

		// 2) 유효성 검사
		if (id == null || id.trim().isEmpty() || password == null || password.trim().isEmpty()) {
			out.println("<html><head><meta charset='UTF-8'><title>오류</title></head><body>");
			out.println("<p>아이디 및 비밀번호를 입력해주세요</p>");
			// 메인 화면(index.html)으로 돌아가는 버튼
			out.println("<button type='button' onclick=\"window.location.href='index.html'\">메인 화면으로 돌아가기</button>");
			out.println("</body></html>");
			out.close();
			resp.sendRedirect("index.html");
			return;
		}

		// 3) DB에 회원 정보 저장 (DAO 호출)
		UserDao userDAO = new UserDao();
		int result = userDAO.insertUser(id, password);

		// HTML 문서 형태로 응답
		out.println("<html><head><meta charset='UTF-8'><title>회원가입 결과</title></head><body>");
		if (result > 0) {
			// 회원가입 성공 시
			out.println("<p>회원가입이 완료되었습니다. (" + id + ")</p>");
		} else {
			// 회원가입 실패 시
			out.println("<p>회원가입에 실패했습니다.</p>");
		}
		// 메인 화면(index.html)으로 돌아가는 버튼
		out.println("<button type='button' onclick=\"window.location.href='index.html'\">메인 화면으로 돌아가기</button>");
		out.println("</body></html>");

		resp.sendRedirect("index.html");
		out.close();
	}
}
