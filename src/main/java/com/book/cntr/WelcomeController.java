package com.book.cntr;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.book.dto.Book;
import com.book.dto.User;
import com.book.service.BookService;
import com.book.service.UserService;

@Controller
public class WelcomeController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	BookService bookService;
	//Index page
	String home() {
		return "index";
	}
	//Go to register page from index page
	@RequestMapping(value = "/register")
	String register() {
		return "register_user";
	}
	//Go to login page from register page
	@RequestMapping(value = "/login")
	String addUser(User user) {
		if(user.getUserName() != null && user.getPassword() != null)
		userService.addUser(user);
		return "login_user";
	}
	// Go to user home page from login page
	@RequestMapping(value = "/logged")
	String loggedUser(User user,HttpServletRequest req,HttpSession session) {
		List<User> li = userService.findUser(user);
		System.out.println(user);
		List<Book> book = bookService.findAll();
		req.setAttribute("book",book);
		if(!li.isEmpty()) {
			session.setAttribute("uname",li.get(0).getUserName());
			return "user_home";
		}else {
			return "login_user";
		}
	}
	// Go to admin login
	@RequestMapping(value = "/admin_login")
	String adminLogin() {
		return "login_admin";
	}
	// Go to admin home
	@RequestMapping(value = "/admin-check")
	String adminCheck(User user) {
		if(user.getUserName().equals("Hrish1") && user.getPassword().equals("4321")) {
			return "admin_home";
		}else {
			return "login_admin";
		}
	}
	@RequestMapping(value = "user-logout")
	String userLogout(HttpSession session) {
		//req.getSession().invalidate();
		session.invalidate();
		return "index";
	}
//	@RequestMapping(value = "/user-home")
//	String userHome(Book book){
//		return "user_home";
//	}
}
