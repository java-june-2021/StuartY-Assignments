package com.stuartyee.thecode.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class IndexController {
	// declaring backend variables privately
	private String code = "bushido";
	private String error = "You must train harder!";
	private String[] values = {"Loyalty", "Courage", "Veracity", "Compassion", "Honor"};
	
	@RequestMapping(path="/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping(path="/submit", method=RequestMethod.POST)
	public String submit(@RequestParam(value="secret") String guess, HttpSession sesh) {
		if (guess.equals(code)) {
			//guessing the correct code initializes the HTTP Session
			//the String array Values contains the Bushido values to be displayed in the code
			//by initializing only with a correct guess, the user cannot cheat by navigating
			//directly to /code
			sesh.setAttribute("values", values);
			return "redirect:/code";
		} else {
			//incorrect guesses clear the Session so /code won't display the values even
			//if previously guessed correctly
			sesh.invalidate();
			return "redirect:/errors";
		}
	}
	
	@RequestMapping(path="/errors")
	public String error(RedirectAttributes redAttr) {
		redAttr.addFlashAttribute("errorString", error);
		return "redirect:/";
	}
	
}
