package com.example.front_controller_practice.model;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface MouseController {
	public void process(HttpServletRequest request , HttpServletResponse response);
}
