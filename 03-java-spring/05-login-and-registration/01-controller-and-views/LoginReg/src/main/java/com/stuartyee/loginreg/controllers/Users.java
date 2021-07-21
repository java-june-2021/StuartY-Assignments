package com.stuartyee.loginreg.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.stuartyee.loginreg.models.User;
import com.stuartyee.loginreg.services.UserService;
import com.stuartyee.loginreg.validations.UserValidator;

//imports removed for brevity
@Controller
public class Users {
	private final UserService userService;
	private final UserValidator uVal;
 
	public Users(UserService userService, UserValidator uVal) {
		this.userService = userService;
		this.uVal = uVal;
	}
 
	@RequestMapping("/registration")
	public String registerForm(@ModelAttribute("user") User user) {
		return "registrationPage.jsp";
	}

	@RequestMapping("/login")
	public String login() {
		return "loginPage.jsp";
	}
 
	@RequestMapping(value="/registration", method=RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		uVal.validate(user, result);
		if(result.hasErrors()) {
			return "registrationPage.jsp";// if result has errors, return the registration page (don't worry about validations just now)
		} else {
			userService.registerUser(user);// else, save the user in the database, save the user id in session, and redirect them to the /home route
			session.setAttribute("id", user.getId());
			return "redirect:/home";
		}
	 	
     
	}
 
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
		
		if(userService.authenticateUser(email, password)) {
			User user = userService.findByEmail(email);
			session.setAttribute("id", user.getId());
			return "redirect:/home";
		} else {
			model.addAttribute("error", "Apologies but it looks like this is an incorrect email/password combination.");
			return "loginPage.jsp";
		}
		// if the user is authenticated, save their user id in session
		// else, add error messages and return the login page
	}
 
	@RequestMapping("/home")
	public String home(HttpSession session, Model model) {
		try {
			Long id = (Long)session.getAttribute("id");
			model.addAttribute("user", userService.findUserById(id));
			System.out.println("User credentials accepted, logging in...");
			return "homePage.jsp";
		// get user from session, save them in the model and return the home page
		} catch (Exception e) {
			System.out.println("No users are logged in, redirecting to login page...");
			return "redirect:/login";
		}
	}
 
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();// invalidate session
		return "redirect:/login";// redirect to login page
	}

}
