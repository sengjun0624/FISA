package com.example.fairtennis.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;



import com.example.fairtennis.model.Reservation;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/tennis/reserve")
public class CourtReserveServlet extends HttpServlet {

	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// form 입력 값 추출
		String reservedTimeString = request.getParameter("datetime");
		LocalDateTime reservedTime = LocalDateTime.parse(reservedTimeString, formatter);

		int courtNumber = Integer.parseInt(request.getParameter("court"));
		String centerName = request.getParameter("center");

		// 예매 처리가 수행되었다고 가정
		Reservation reservation = new Reservation(centerName, courtNumber, reservedTime);

		request.setAttribute("reservation", reservation);

		final String path = "/success.jsp";
		System.out.println("scheduled success");
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
		// response.sendRedirect(request.getContextPath() + "/success.jsp");

	}

}
