package com.book.cntr;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	@RequestMapping(value = "/user-home")
	public String userHome(HttpServletRequest req,HttpSession session) {
		List<Book> book = bookService.findAll();
		session.setAttribute("book",book);
		return "user_home";
	} 
	// Go to user home page from login page
	@RequestMapping(value = "/logged")
	String loggedUser(User user,HttpServletRequest req,HttpSession session) {
		List<User> li = userService.findUser(user);
		System.out.println(user);
		List<Book> book = bookService.findAll();
		session.setAttribute("book",book);
		if(!li.isEmpty()) {
			session.setAttribute("uname",li.get(0).getUserName());
			session.setAttribute("uid",li.get(0).getId());
			session.setAttribute("name", li.get(0).getName());
			session.setAttribute("pass",li.get(0).getPassword());
			session.setAttribute("mail",li.get(0).getMail());
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
	String adminCheck(User user,HttpSession session) {
		if(user.getUserName().equals("Hrish1") && user.getPassword().equals("4321")) {
			session.setAttribute("name","Hrish1");
			session.setAttribute("AllBooks", bookService.findAll());
			return "admin_home";
		}else {
			return "login_admin";
		}
	}
	@GetMapping("/admin-logout")
	String adminLogout(HttpSession session) {
		session.invalidate();
		return "index";
	}
	@RequestMapping(value = "user-logout")
	String userLogout(HttpSession session) {
		//req.getSession().invalidate();
		session.invalidate();
		return "index";
	}
	@GetMapping("/show-users")
	public String showAllUsers(HttpServletRequest request) {
		request.setAttribute("users", userService.showAllUsers());
		request.setAttribute("mode", "ALL_USERS");
		return "showAllUsers";
	}
//	@RequestMapping(value = "/user-home")
//	String userHome(Book book){
//		return "user_home";
//	}
	@RequestMapping("/delete-user")
	public String deleteUser(@RequestParam int id, HttpServletRequest request) {
		userService.deleteMyUser(id);
		request.setAttribute("users", userService.showAllUsers());
		request.setAttribute("mode", "ALL_USERS");
		return "showAllUsers";
	}
	
	@RequestMapping("/edit-user")
	public String editUser(@RequestParam int id,HttpServletRequest request) {
		request.setAttribute("user", userService.editUser(id));
		request.setAttribute("mode", "MODE_UPDATE");
		return "showAllUsers";
	}
	@PostMapping("/save-user")
	public String registerUser(@ModelAttribute User user, BindingResult bindingResult, HttpServletRequest request) {
		userService.saveMyUser(user);
		request.setAttribute("users", userService.showAllUsers());
		request.setAttribute("mode", "ALL_USERS");
		return "showAllUsers";
	}
	
//	@RequestMapping("/login")
//	public String login(HttpServletRequest request) {
//		request.setAttribute("mode", "MODE_LOGIN");
//		return "login_user";
//	}
//	
//	@RequestMapping ("/login-user")
//	public String loginUser(@ModelAttribute User user, HttpServletRequest request) {
//		if(userService.findByUsernameAndPassword(user.getUserName(), user.getPassword())!=null) {
//			return "user_home";
//		}
//		else {
//			request.setAttribute("error", "Invalid Username or Password");
//			request.setAttribute("mode", "MODE_LOGIN");
//			return "login_user";
//			
//		}
//	}
	
}
