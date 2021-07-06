package com.stuartyee.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.RequestMapping;

import com.stuartyee.languages.models.Language;
import com.stuartyee.languages.services.LanguageService;

@Controller
public class MainController {
	
	private final LanguageService languageService;
	
	public MainController(LanguageService languageService) {
		this.languageService = languageService;
	}
	
	@GetMapping("/languages")
	public String showLanguages(Model model) {
		// build routing to show all languages
		List<Language> languages = languageService.allLanguages();
		model.addAttribute("languages", languages);
		model.addAttribute("newLanguage", new Language()); //SO solution?
		return "index.jsp";
	}
	
	@PostMapping("/languages")
	public String newLanguage(@Valid @ModelAttribute("newLanguage") Language language, BindingResult result) {
		if(result.hasErrors()) {
			return "index.jsp";
		} else {
			languageService.createLanguage(language);
			return "redirect:/languages";
		}
		//create language
	}
	
	@GetMapping("/languages/{id}")
	public String viewLanguage(@PathVariable("id") Long id, Model model) {
		if(languageService.idExists(id)) {
			model.addAttribute("languageView", languageService.findLanguage(id));
			return "display.jsp";
		} else {
			return "redirect:/languages";
		}
		//use path variable to access language details
	}
	
	@GetMapping("/languages/{id}/edit")
	public String editLanguage(@Valid @PathVariable("id") Long id, Model model) {
		if(languageService.idExists(id)) {
			model.addAttribute("languageView", languageService.findLanguage(id));
			return "edit.jsp";
		} else {
			return "redirect:/languages";
		}
		
		
	}
	
	@PostMapping("/languages/{id}/edit")
	public String updateLanguage(@Valid @PathVariable("id") Long id, @ModelAttribute("languageView") Language language, BindingResult result) {
		if(result.hasErrors()) {
			return "edit.jsp";
		} else {
			languageService.edit(id, language);
			return "redirect:/languages";
		}
		
	}
	
	@GetMapping("/languages/{id}/delete")
	public String deleteLanguage(@PathVariable("id") Long id) {
		if(languageService.idExists(id)) {
			languageService.delete(id);
		}
		return "redirect:/languages";
	}

}
