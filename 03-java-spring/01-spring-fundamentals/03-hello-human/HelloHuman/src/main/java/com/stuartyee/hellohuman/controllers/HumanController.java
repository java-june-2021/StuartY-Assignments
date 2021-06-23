package com.stuartyee.hellohuman.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HumanController{
	String yourName;
	
	@RequestMapping("/")
	public String index(Model model) {
		yourName = "Human";
		model.addAttribute("yourName", yourName);
		model.addAttribute("link", null);
		return "index.jsp";
	}
	
	@RequestMapping("/{name}")
	public String nameGreeting(@PathVariable("name") String newName, Model model) {
		yourName = newName;
		System.out.println(newName);
		model.addAttribute("yourName", yourName);
		model.addAttribute("link", "Go back");
		return "index.jsp";
	}
	
}
