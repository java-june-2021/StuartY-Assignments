package com.stuartyee.dojooverflow.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.stuartyee.dojooverflow.models.Answer;
import com.stuartyee.dojooverflow.models.Question;
import com.stuartyee.dojooverflow.models.Tag;
import com.stuartyee.dojooverflow.services.AnswerService;
import com.stuartyee.dojooverflow.services.QuestionService;
import com.stuartyee.dojooverflow.services.TagService;

@Controller
public class MainController {
	
	@Autowired
	private QuestionService qServ;
	@Autowired
	private TagService tServ;
	@Autowired 
	private AnswerService aServ;
	
	
	//Main dashboard
	@GetMapping("/questions")
	public String questionsDashboard(Model viewModel) {
		List<Question> allQuestions = qServ.findAllQuestions();
		viewModel.addAttribute("questions", allQuestions);
		return "dashboard.jsp"; 
	}
	
	//The next Get and Post pair handle creating a new Question and adding
	//tags to that Question
	@GetMapping("/questions/new")
	public String newQuestion(@ModelAttribute("tagError") String error,
			@ModelAttribute("qString") String question, @ModelAttribute("tString") String tag
			) {
		//get mapping to pull up jsp for new questions
		return "newQuestion.jsp";
	}
	
	@PostMapping("/questions/new")
	public String postQuestion(@RequestParam("question") String question, 
			@RequestParam("tags") String tags, RedirectAttributes redAtt) {
		if(tServ.processTag(tags) == null) { //in other words, there are more than 4 tags
			//this is the error message
			redAtt.addFlashAttribute("tagError", "Can only accept 3 tags");
			//this is pulling the previous user entries and putting them back so the user doesn't lose them
			redAtt.addFlashAttribute("qString", question);
			redAtt.addFlashAttribute("tString", tags);
			return "redirect:/questions/new";
		} else if(question.isBlank() || (question.length() <10)){
			redAtt.addFlashAttribute("qError", "Please enter at least 10 characters.");
			//this is pulling the previous user entries and putting them back so the user doesn't lose them
			redAtt.addFlashAttribute("tString", tags);
			return "redirect:/questions/new";
		} else {
			//Create a new Question from the text entry and save it to the database
			Question newQuestion = new Question();
			newQuestion.setQuestion(question);
			qServ.createQuestion(newQuestion);
			if(tags.isBlank() == false) {
				System.out.println("Here is the tag entry");
				System.out.println("Blank entry?" + tags.isBlank());
				System.out.println(tags);
				//There should be only 3 tags and we'll see if they exist or not
				List<Tag> tagList = tServ.processTag(tags);
				//We now have a list of tags (some of which may be old or new) and will
				//need to add them to new Question
				newQuestion.setTags(tagList);
				qServ.createQuestion(newQuestion); //Save the question!
			}
			return "redirect:/questions";
		}		
	}
	
	//Get and post pair are for opening a question page
	//and being able to post an answer
	@GetMapping("/questions/{id}")
	public String viewQuestion(@ModelAttribute("newAnswer") Answer answer, @PathVariable("id") Long id, Model viewModel) {
		viewModel.addAttribute("theQuestion", qServ.findQuestionById(id));
		//view question
		//related tags
		//list of answers
		return "question.jsp"; 
	}
	
	@PostMapping("/questions/{id}")
	public String postAnswer(@Valid @ModelAttribute("newAnswer") Answer answer, BindingResult result, @PathVariable("id") Long id){
		//MVC form!
		//create answer and attach it to the question
		if(result.hasErrors()) {
			return "question.jsp";
		} else {
			aServ.saveAnswer(answer);
			Question thisQuestion = qServ.findQuestionById(id);
			thisQuestion.getAnswers().add(answer);
			qServ.createQuestion(thisQuestion); //not really "creating" a question, just saving it
			answer.setQuestion(thisQuestion);
			aServ.saveAnswer(answer);
			return "redirect:/questions/{id}";
		}
		
	}
	

}
