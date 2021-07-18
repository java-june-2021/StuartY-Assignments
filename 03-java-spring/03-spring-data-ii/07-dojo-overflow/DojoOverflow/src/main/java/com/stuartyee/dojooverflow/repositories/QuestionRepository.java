package com.stuartyee.dojooverflow.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stuartyee.dojooverflow.models.Question;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Long> {
	
	public List<Question> findAll();
	public Optional<Question> findById(Long id);

}
