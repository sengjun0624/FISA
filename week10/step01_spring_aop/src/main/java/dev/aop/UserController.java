package dev.aop;

import java.util.ArrayList;
import java.util.List;

public class UserController {

	public void getUsers() {
		// DB로부터 User 목록을 받았다고 가정
		List<User> users = new ArrayList<>();
		users.add(new User(1, "Tom"));
		users.add(new User(2, "Jerry"));
	}
}
