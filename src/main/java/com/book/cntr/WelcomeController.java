package com.book.cntr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.book.dto.User;
import com.book.service.UserService;

@Controller
public class WelcomeController {
	
	@Autowired
	UserService userService;
	
	String home() {
		return "index";
	}
	@RequestMapping(value = "/register")
	String register() {
		return "register_user";
	}
	@RequestMapping(value = "/login")
	String addUser(User user) {
		userService.addUser(user);
		return "login_user";
	}
	@RequestMapping(value = "/logged")
	String loggedUser(User user) {
		List<User> li = userService.findUser(user);
		System.out.println(li.get(0));
		if(!li.isEmpty()) {
			return "index";
		}else {
			return "login_user";
		}
	}
	@RequestMapping(value = "/admin_login")
	String adminLogin() {
		return "login_admin";
	}
	@RequestMapping(value = "/admin-check")
	String adminCheck(User user) {
		if(user.getUserName().equals("Hrish1") && user.getPassword().equals("4321")) {
			return "admin_home";
		}else {
			return "login_admin";
		}
	}
}
