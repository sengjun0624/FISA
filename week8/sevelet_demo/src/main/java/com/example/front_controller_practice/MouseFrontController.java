package com.example.front_controller_practice;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.example.front_controller_practice.model.MouseController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// root 경로가 mouse-api인 모든 요청에 대해 처리하는 서블릿
@WebServlet(urlPatterns = "/mice/*")
public class MouseFrontController extends HttpServlet {
	private static final Map<String, MouseController> L2Switch = new HashMap<>();
	private static  MouseController mouseController = null;

	static {
		L2Switch.put("/list", new MouseListController());
		L2Switch.put("/add", new MouseInsertController());
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws
		ServletException,
		IOException {

		// 대부분의 컨트롤러(서블릿)에서 수행되는 공통 처리 로직 작성
		request.setCharacterEncoding("UTF-8");

		// 사용자로부터 전달받은 요청 URI값을 확인, ex. lh:8080/mouse-api/mice/add일 경우,
		String path = request.getPathInfo(); // /mice/add
		if (!Objects.isNull(L2Switch.get(path))) {
			mouseController = L2Switch.get(path);
		} else {
			System.out.println("path Invalid");
			return;
		}
		mouseController.process(request, response);
	}

}

