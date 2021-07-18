package com.stuartyee.dojooverflow.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stuartyee.dojooverflow.repositories.AnswerRepository;
import com.stuartyee.dojooverflow.models.Answer;

@Service
public class AnswerService {

	AnswerRepository aRepo;

	public AnswerService(AnswerRepository aRepo) {
		this.aRepo = aRepo;
	}
	
	public void saveAnswer(Answer answer) {
		aRepo.save(answer);
	}
	
	public List<Answer> findAllAnswers(){
		return aRepo.findAll();
	}
	
	public Answer findAnswerById(Long id) {
		if(aRepo.findById(id).isPresent()) {
			return aRepo.findById(id).get();
		} else {
			return null;
		}
	}
	
	
	
	
	
	
}
