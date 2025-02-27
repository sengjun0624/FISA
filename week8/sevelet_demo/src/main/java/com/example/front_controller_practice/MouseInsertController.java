package com.example.front_controller_practice;

import java.io.IOException;
import java.sql.SQLException;

import com.example.front_controller_practice.model.Mouse;
import com.example.front_controller_practice.model.MouseController;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MouseInsertController implements MouseController {
	private static final MouseDao mouseDao = new MouseDao();


	@Override
	public void process(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.setCharacterEncoding("UTF-8");

			String name = req.getParameter("name");
			String country = req.getParameter("country");
			String address = req.getParameter("address");

			if (name.isEmpty() || country.isEmpty() || address.isEmpty()) {
				System.out.println("입력이 올바르지 않습니다.");
				return;
			}
			mouseDao.insertMouse(new Mouse(name, country, address));
			resp.sendRedirect("index.html");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
