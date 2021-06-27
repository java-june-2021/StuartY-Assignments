package com.stuartyee.thecode.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CodeController {
	
	
	@RequestMapping("/code")
	public String code() {
		
		return "code.jsp";
	}
	

}
