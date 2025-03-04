package com.example.front_controller_practice.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Controller {
	public Object process(HttpServletRequest request , HttpServletResponse response);
}
