package dev.mvc.step02.mvc_basic.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SecondController {

	@RequestMapping(value = "/second-controller", method = RequestMethod.GET)
	public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("Second 컨트롤러가 호출됨.");
	}
}
