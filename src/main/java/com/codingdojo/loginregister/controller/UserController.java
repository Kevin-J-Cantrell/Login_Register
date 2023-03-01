package com.codingdojo.loginregister.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.loginregister.model.LoginUser;
import com.codingdojo.loginregister.model.User;
import com.codingdojo.loginregister.services.UserServices;

@Controller
public class UserController {

	  @Autowired
	  private UserServices userService;
	 
	 @GetMapping("/")
	 public String index(Model model) {
	 
	     model.addAttribute("Register", new User());
	     model.addAttribute("Login", new LoginUser());
	     return "register.jsp";
	 }
	 
	 @PostMapping("/register")
	 public String register(@Valid @ModelAttribute("Register") User newUser, 
	         BindingResult result, Model model, HttpSession session) {
	     
	     userService.register(newUser, result);
	     if(result.hasErrors()) {
	         model.addAttribute("Login", new LoginUser());
	         return "register.jsp";
	     }
	     
	     session.setAttribute("Id", newUser.getId());
	 
	     return "redirect:/dashboard";
	 }
	 
	 @PostMapping("/login")
	 public String login(@Valid @ModelAttribute("Login") LoginUser Login, 
	         BindingResult result, Model model, HttpSession session) {
	     

	     User user = userService.login(Login, result);
	 
	     if(result.hasErrors()) {
	         model.addAttribute("Register", new User());
	         return "register.jsp";
	     }
	 
	     session.setAttribute("Id", user.getId());
	 
	     return "redirect:/dashboard";
	 }
	 
	 @GetMapping("/logout")
	 public String logout(HttpSession session) {
		 session.setAttribute("Id", null);
		 return "redirect:/";
	 }
	 
	 @GetMapping("/dashboard")
	 public String Dash(Model model, HttpSession session) {
		 Long Id = (Long) session.getAttribute("Id");
		 if(Id==null) {
			 return "redirect:/";
		 }
		 User user = userService.findById(Id);
		 model.addAttribute("user",user);
		 return "dashboard.jsp";
	 }
}
