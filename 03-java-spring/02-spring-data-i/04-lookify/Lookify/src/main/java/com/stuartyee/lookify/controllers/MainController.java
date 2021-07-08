package com.stuartyee.lookify.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.stuartyee.lookify.models.Song;
import com.stuartyee.lookify.services.SongServices;

@Controller
public class MainController {
	
	private final SongServices sServ;

	public MainController(SongServices sServ) {
		this.sServ = sServ;
	}
	
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}

	@GetMapping("/dashboard")
	public String dashboard(Model model) {
		model.addAttribute("songs", sServ.allSongs());
		return "dashboard.jsp";
	}
	
	@GetMapping("/songs/{id}")
	public String viewSong(@PathVariable("id") Long id, Model model) {
		model.addAttribute("song", sServ.findSongById(id));
		return "viewSong.jsp";
	}
	
	@GetMapping("/songs/new")
	public String newSong(@ModelAttribute("newSong") Song song) {
		return "newSong.jsp"; 
	}

	@PostMapping("/songs/new")
	public String createSong(@Valid @ModelAttribute("newSong") Song song, BindingResult result) {
		if(result.hasErrors()) {
			return "newSong.jsp";
		} else {
			sServ.createSong(song);
			return "redirect:/dashboard";
		}
	}
	
	@RequestMapping("/delete/{id}")
	public String deleteSong(@PathVariable("id") Long id) {
		sServ.deleteSong(id);
		return "redirect:/dashboard";
	}


	@GetMapping("/search/topTen")
	public String topTen(Model model) {
		Song[] topTen = sServ.topTen();
		model.addAttribute("songs", topTen);
		return "topTen.jsp";
	}

	@RequestMapping("/search")
	public String search(@RequestParam("search") String search, Model model) {
		model.addAttribute("songs", sServ.searchByArtist(search));
		model.addAttribute("search", search);
		return "search.jsp"; 
	}
	
	
	

}
