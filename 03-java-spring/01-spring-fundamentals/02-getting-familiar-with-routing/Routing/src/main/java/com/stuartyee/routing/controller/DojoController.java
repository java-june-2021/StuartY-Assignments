package com.stuartyee.routing.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dojo")
public class DojoController {
	
	@RequestMapping("")
	public String dojoGreeting() {
		return "The dojo is awesome!";
	}
	
	@RequestMapping("/{path}")
	public String pathGreeting(@PathVariable("path") String path) {
		if(path.equals("Burbank") == true) {
			return "Burbank Dojo is located in Southern California";
		} else if(path.equals("San-Jose")) {
			return "SJ dojo is the headquarters";
		} else {
			return "Sorry! I don't know if there's a dojo in " + path;
		}
	}
	
	

}
