package com.example.jsp_practice.servlet_practice;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.example.jsp_practice.servlet_practice.model.Mouse;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/get-mouse")
public class MouseListServlet extends HttpServlet {
	private static final MouseDao dao = new MouseDao();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {

		resp.setContentType("text/html;charset=UTF-8");
		PrintWriter out = resp.getWriter();

		// DB에서 Mouse 데이터를 모두 조회합니다.
		List<Mouse> mice = dao.findAll();

		// HTML 응답을 StringBuilder로 구성
		StringBuilder responseHTML = new StringBuilder();

		responseHTML.append("<html>");
		responseHTML.append("    <head>");
		responseHTML.append("        <title>Mouse 목록 페이지</title>");
		responseHTML.append("    </head>");
		responseHTML.append("    <body>");
		responseHTML.append("        <h1>Mouse 목록 페이지</h1>");
		responseHTML.append("<a href=\"/index.html\">홈페이지로</a>");
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

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Mouse> mice = dao.findAll();
		for(Mouse mouse: mice)
			System.out.println(mouse.toString());
		// TODO: mice 에 담긴 mouse 데이터들이 mouseList.jsp로 전달되어서 화면에 출력되어야함.
		req.setAttribute("mouseList", mice);
		Object mouseList = req.getAttribute("mouseList");
		System.out.println("-------"+mouseList.toString());
		// JSP 페이지로 포워드
		String url = "mouseList.jsp";
		RequestDispatcher dispatcher = req.getRequestDispatcher(url);
		dispatcher.forward(req, resp);

		resp.setStatus(200);
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
	}
}
