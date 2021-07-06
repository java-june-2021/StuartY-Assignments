package com.stuartyee.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.stuartyee.languages.models.Language;
import com.stuartyee.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	
	private LanguageRepository languageRepo;

	public LanguageService(LanguageRepository languageRepo) {
		this.languageRepo = languageRepo;
	}
	
	public List<Language> allLanguages(){
		return languageRepo.findAll();
	}
	
	public Language createLanguage(Language language) {
		return languageRepo.save(language);
	}
	
	public Language findLanguage(Long id) {
		Optional<Language> optLanguage = languageRepo.findById(id);
		if(optLanguage.isPresent()) {
			return optLanguage.get();
		} else {
			return null;
		}	
	}
	
	public void edit(Long id, Language language) {
		if(languageRepo.existsById(id)) {
			languageRepo.save(language);
		}
	}
	
	public void delete(Long id) {
		//TODO build
		if(languageRepo.existsById(id)) {
			languageRepo.deleteById(id);
		}
	}
	
	public boolean idExists(Long id) {
		return languageRepo.existsById(id);
	}
	
	

}
