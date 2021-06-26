package com.stuartyee.counter.controllers;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CounterController {
	
	private void counter(HttpSession session) {
		if(session.getAttribute("visits") == null) {
			session.setAttribute("visits", 0);
		}
	}
	
	@RequestMapping("/")
	public String index(HttpSession sesh) {
		counter(sesh);
		int count = (int)sesh.getAttribute("visits");
		count++;
		sesh.setAttribute("visits", count);
		return "index.jsp";
	}
	
	@RequestMapping("/double")
	public String doubleCount(HttpSession sesh) {
		counter(sesh);
		int count = (int)sesh.getAttribute("visits");
		count += 2;
		sesh.setAttribute("visits", count);
		return "doublecount.jsp";
	}
	
	@RequestMapping("/counter")
	public String viewCounter(HttpSession sesh) {
		counter(sesh);
		return "counter.jsp";
	}
	
	@RequestMapping("/reset")
	public String resetCount(HttpSession sesh) {
		sesh.invalidate();
		return "redirect:/counter";
	}

}
