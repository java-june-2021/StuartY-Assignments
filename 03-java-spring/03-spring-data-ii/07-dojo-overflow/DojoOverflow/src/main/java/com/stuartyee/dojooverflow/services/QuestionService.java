package com.stuartyee.dojooverflow.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stuartyee.dojooverflow.repositories.QuestionRepository;
import com.stuartyee.dojooverflow.models.Answer;
import com.stuartyee.dojooverflow.models.Question;
import com.stuartyee.dojooverflow.models.Tag;

@Service
public class QuestionService {
	
	private QuestionRepository qRepo;

	public QuestionService(QuestionRepository qRepo) {
		this.qRepo = qRepo;
	}
	
	//Service method to retrieve all questions in order to display
	//in a dashboard
	public List<Question> findAllQuestions(){
		return qRepo.findAll();
	}
	
	//Creating a new question and saving into db
	public void createQuestion(Question question) {
		qRepo.save(question);
	}
	
	//Service method pulls a question by ID
	//to access its details page and related tags
	//and answers
	public Question findQuestionById(Long id) {
		if (qRepo.findById(id).isPresent()) {
			return qRepo.findById(id).get();
		} else {
			return null;
		}
	}
	
	//Service to add tags to question
	public void addTagsToQuestion(Question question, List<Tag> tags) {
		for(Tag tag: tags) {
			question.getTags().add(tag);
		}
		qRepo.save(question);
		
	}
	
	//Add answers to the question
	public void addAnswerToQuestion(Question question, Answer answer) {
		question.getAnswers().add(answer);
		qRepo.save(question);		
	}
	

}
