package com.example.sevelet_demo.step04_query_string;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/query-test-kor")
public class QueryServletKo extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");

		PrintWriter out = resp.getWriter();

		out.print("<h1>GET 방식으로 요청 되었음.</h1>");
		out.print("이름 : " + name + " <br/> ");

		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");

		String name = req.getParameter("name");

		PrintWriter out = resp.getWriter();

		out.println("<html>");
		out.println("<body>");
		out.println("<head>");
		out.println("<title>Request Information Example</title>");
		out.println("</head>");
		out.println("<body>");
		out.print("<h1>POST 방식으로 요청 되었음.</h1>");
		out.print("이름 : " + name + " <br/> ");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}
}
