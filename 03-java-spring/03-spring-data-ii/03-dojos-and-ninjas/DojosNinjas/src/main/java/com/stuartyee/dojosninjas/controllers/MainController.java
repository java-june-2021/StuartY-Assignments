package com.stuartyee.dojosninjas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.stuartyee.dojosninjas.models.Dojo;
import com.stuartyee.dojosninjas.models.Ninja;
import com.stuartyee.dojosninjas.services.DojoService;
import com.stuartyee.dojosninjas.services.NinjaService;

@Controller
public class MainController {
	
	@Autowired
	private DojoService dServ;
	
	@Autowired 
	private NinjaService nServ;

	@GetMapping("/dojos/new")
	public String toNewDojo(@ModelAttribute("newDojo")Dojo newDojo, BindingResult result) {
		return "newDojo.jsp";
	}
	
	@PostMapping("/dojos/new")
	public String newDojo(@Valid @ModelAttribute("newDojo")Dojo newDojo, BindingResult result) {
		if(result.hasErrors()) {
			return "newDojo.jsp";
		} else {
			dServ.createDojo(newDojo);
			return "redirect:/dojos/new";
		}
	}
	
	@GetMapping("/ninjas/new")
	public String toNewNinja(@ModelAttribute("newNinja") Ninja ninja, Model model, BindingResult result) {
		model.addAttribute("dojos", this.dServ.findAllDojos());
		return "newNinja.jsp";
	}
	
	@PostMapping("/ninjas/new")
	public String newNinja(@Valid @ModelAttribute("newNinja") Ninja ninja, BindingResult result) {
		if(result.hasErrors()) {
			return "newNinja.jsp";
		} else {
			this.nServ.createNinja(ninja);
			return "redirect:/ninjas/new";
		}		
	}
	
	@GetMapping("/dojos/{id}")
	public String dojoNinjas(@PathVariable("id") Long id, Model model) {
		Dojo thisDojo = this.dServ.findByDojoId(id);
		model.addAttribute("thisDojo", thisDojo);
		model.addAttribute("dojoNinjas", this.nServ.findNinjasByDojo(thisDojo));
		return "dojoNinjas.jsp";
	}

}
