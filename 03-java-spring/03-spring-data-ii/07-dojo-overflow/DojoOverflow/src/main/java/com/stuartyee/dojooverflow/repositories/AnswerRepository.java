package com.stuartyee.dojooverflow.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stuartyee.dojooverflow.models.Answer;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Long> {
	
	public List<Answer> findAll();
	public Optional<Answer> findById(Long id);

}
