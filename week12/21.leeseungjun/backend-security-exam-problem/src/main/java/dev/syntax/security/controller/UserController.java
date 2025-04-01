package dev.syntax.security.controller;

import java.io.IOException;
import java.net.http.HttpResponse;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import dev.syntax.security.model.User;
import dev.syntax.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 문제3. 전체 사용자 목록 조회 기능
    @GetMapping
    public String getUsers(Model model) {
        List<User> all = userService.findAll();
        model.addAttribute("users", all);
        return "userList";
    }

    // 문제1. 사용자 회원가입 기능
    @PostMapping("/register")
    public void createUser(@ModelAttribute User user , HttpServletResponse response) throws IOException {
        userService.createUser(user);
        response.sendRedirect("/login");
    }

    // 문제2. 사용자 로그인이 성공할 경우 응답 처리를 수행할 핸들러
    @GetMapping("/profile")
    public String showMyPage(Authentication authentication, Model model) {
        // TODO: profile.html에 작성된 안녕하세요 {username}! 이 정상적으로 출력되도록 구현 ex) 안녕하세요 gugu!
        String name = authentication.getName();
        model.addAttribute("username",name);
        return "profile";
    }
}
