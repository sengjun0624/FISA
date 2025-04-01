package dev.syntax.security.service;

import java.util.List;

import dev.syntax.security.model.User;

public interface UserService {

    // 문제1. 사용자 회원 가입 기능
    void createUser(User user);
    User getUserByUserName(String username);
    List<User> findAll();
}
