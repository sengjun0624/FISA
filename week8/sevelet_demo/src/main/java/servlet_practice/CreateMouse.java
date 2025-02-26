package servlet_practice;

import java.io.IOException;

import servlet_practice.model.Mouse;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// @WebServlet("/create-mouse")
public class CreateMouse extends HttpServlet {
	private static final MouseDao mouseDao = new MouseDao();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");

		String name = req.getParameter("name");
		String country = req.getParameter("country");
		String address = req.getParameter("address");

		if(name.isEmpty()||country.isEmpty()||address.isEmpty()){
			System.out.println("입력이 올바르지 않습니다.");
			return;
		}
		mouseDao.insertMouse(new Mouse(name, country, address));
		resp.sendRedirect("index.html");

	}
}
