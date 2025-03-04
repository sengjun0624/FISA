package servlet_practice;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// @WebServlet("/update")
public class UpdateInfoServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		StringBuilder responseHTML = new StringBuilder();
		resp.setContentType("text/html");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		responseHTML.append("<html>");
		responseHTML.append("   <head>");
		responseHTML.append("       <meta charset=\"UTF-8\"/>");
		responseHTML.append("       <title>Mouse 수정 페이지</title>");
		responseHTML.append("   </head>");
		responseHTML.append("       <body>");
		final String URL = "\"update-mouse\"";
		final String HTTP_METHOD = "\"POST\"";
		String formAttribute = String.format("action=%s method=%s", URL, HTTP_METHOD);
		responseHTML.append("<h1>Mouse 등록 페이지</h1>");
		responseHTML.append("           <form " + formAttribute + ">");
		String idInputAttribute = "type=\"text\" name=\"id\"";
		responseHTML.append("           id: <input " + idInputAttribute + "><br/>");
		String nameInputAttribute = "type=\"text\" name=\"name\"";
		responseHTML.append("           name: <input " + nameInputAttribute + "><br/>");
		String countryInputAttribute = "type=\"text\" name=\"country\"";
		responseHTML.append("           country: <input " + countryInputAttribute + "><br/>");
		String addressInputAttribute = "type=\"text\" name=\"address\"";
		responseHTML.append("           address: <input " + addressInputAttribute + "><br/>");
		String buttonAttribute = "type=\"submit\"";
		responseHTML.append("           <button " + buttonAttribute + ">수정</button><br/>");
		responseHTML.append("       </body>");
		out.println(responseHTML.toString());
		out.close();
	}
}
