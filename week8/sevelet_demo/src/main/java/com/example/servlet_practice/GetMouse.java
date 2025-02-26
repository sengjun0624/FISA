package com.example.servlet_practice;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


import com.example.servlet_practice.model.Mouse;

@WebServlet("/get-mouse")
public class GetMouse extends HttpServlet {
	private static final MouseDao dao = new MouseDao();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {

		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();

		// DB에서 Mouse 데이터를 모두 조회합니다.
		List<Mouse> mice = dao.getMouse();

		// HTML 응답을 StringBuilder로 구성
		StringBuilder responseHTML = new StringBuilder();

		responseHTML.append("<html>");
		responseHTML.append("    <head>");
		responseHTML.append("        <title>Mouse 목록 페이지</title>");
		responseHTML.append("    </head>");
		responseHTML.append("    <body>");
		responseHTML.append("        <h1>Mouse 목록 페이지</h1>");
		responseHTML.append("<a href=\"/mouse\">등록페이지로</a>");
		responseHTML.append("        <ul>");

		// li 스타일: flex 디스플레이, 리스트 스타일 없음
		String liStyle = "style=\"display:flex; list-style:none;\"";
		for (Mouse mouse : mice) {
			responseHTML.append("<li " + liStyle + ">");
			responseHTML.append(String.format("<div>%s</div>", mouse.getName()));
			responseHTML.append(String.format("<div>%s</div>", mouse.getCountry()));
			responseHTML.append(String.format("<div>%s</div>", mouse.getAddress()));
			responseHTML.append("</li>");
		}
		responseHTML.append("        </ul>");
		responseHTML.append("    </body>");
		responseHTML.append("</html>");

		out.println(responseHTML.toString());
		out.close();
	}
}
