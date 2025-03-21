package com.example.front_controller_practice.controller;

import java.io.PrintWriter;
import java.util.List;

import com.example.front_controller_practice.DAO.MouseDAO;
import com.example.front_controller_practice.model.ModelAndView;
import com.example.front_controller_practice.model.Mouse;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * 실제 Moust 목록 조회 처리를 수행할 컨트롤러
 */
public class MouseController implements Controller {
	private static final MouseDAO dao = new MouseDAO();

	public ModelAndView process(HttpServletRequest req, HttpServletResponse resp) {
		try {
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
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
