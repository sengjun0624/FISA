package com.example.jsp_practice.servlet_practice;

import java.io.IOException;

import com.example.jsp_practice.servlet_practice.model.Mouse;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// @WebServlet("/update-mouse")
public class MouseUpdateServlet extends HttpServlet {
	private static final MouseDao dao = new MouseDao();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String country = req.getParameter("country");
		String address = req.getParameter("address");

		dao.updateMouseById(id, new Mouse(name, country, address));
		resp.sendRedirect("/get-mouse");

	}
}
