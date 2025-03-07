package dev.mvc.step02.resolving_view.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component(value = "/resolving/first-controller")
public class FirstController implements Controller {
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// ModelAndView 객체에 적절한 View 파일명과 화면에 렌더링할 Model 데이터만 바인딩해주고,
		// 반환하면 나머지는 DispatcherServlet이 처리

		// ModelAndView 객체 생성
		ModelAndView mnv = new ModelAndView();

		// 현재는 필요한 모델 데이터는 없다고 가정

		// 적절한 View 파일명만 view 필드에 바인딩
		mnv.setViewName("home"); // /WEB-INF/views/"home".jsp에서 파일명(home)만 지정

		return mnv; // ModelAndView를 반환
	}
}
