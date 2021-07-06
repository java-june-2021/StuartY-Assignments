package com.stuartyee.languages.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stuartyee.languages.models.Language;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long> {
	
	//retrieves all Language objects
	List<Language> findAll();
	
	//query by language name
	List<Language> findByName(String search);
	
	
	

}
