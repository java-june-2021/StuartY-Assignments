package com.stuartyee.thecode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class IndexController {
	String code = "bushido";
	String error = "You must train harder!";
	
	@RequestMapping(path="/")
	public String index() {
		return "index.jsp";
	}
	
	@RequestMapping(path="/submit", method=RequestMethod.POST)
	public String submit(@RequestParam(value="secret") String guess) {
		if (guess.equals(code)) {
			return "redirect:/code";
		} else {
			return "redirect:/errors";
		}
	}
	
	@RequestMapping(path="/errors")
	public String error(RedirectAttributes redAttr) {
		redAttr.addFlashAttribute("errorString", error);
		return "redirect:/";
	}
	
}
