package com.stuartyee.counter.controllers;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CounterController {
	
	int counter = 0;
	
	@RequestMapping("/")
	public String index() {
		counter++;
		return "index.jsp";
	}
	
	@RequestMapping("/counter")
	public String counter(HttpSession session) {
		session.setAttribute("visits", counter);
		return "counter.jsp";
	}

}
