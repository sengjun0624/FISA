package com.example.front_controller_practice;

import java.io.IOException;

import com.example.front_controller_practice.model.Mouse;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// @WebServlet("/update-mouse")
public class UpdateMouse extends HttpServlet {
	private static final MouseDao dao = new MouseDao();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");

		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String country = req.getParameter("country");
		String address = req.getParameter("address");

		dao.updateMouse(id, new Mouse(name, country, address));
		resp.sendRedirect("/get-mouse");

	}
}
