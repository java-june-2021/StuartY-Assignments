package com.stuartyee.displaydate.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DateController {
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping("/{request}")
	public String routeRequest(Model model, @PathVariable("request") String request) {
		String datetime; 
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter hourMinutes = DateTimeFormatter.ofPattern("K:mm a");
		DateTimeFormatter dayOfWeek = DateTimeFormatter.ofPattern("EEEE");
		DateTimeFormatter dayOfMonth = DateTimeFormatter.ofPattern("dd");
		DateTimeFormatter monthYear = DateTimeFormatter.ofPattern("MMMM, yyyy");
		
		

		if(request.equals("date") == true) {
			datetime = now.format(dayOfWeek) + ", the " + now.format(dayOfMonth) + " of " + now.format(monthYear);
			System.out.println(datetime);
			model.addAttribute("datetime", datetime);
			return "date.jsp";
		} else if (request.equals("time")) {
			datetime = now.format(hourMinutes);
			System.out.println(datetime);
			model.addAttribute("datetime", datetime);
			return "time.jsp";
		} else {
			model.addAttribute("whoops!", request);
			return "index.jsp";
		}
		
		
	}

}
