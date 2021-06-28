package com.stuartyee.dojosurvey.controllers;

import java.util.ArrayList;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.HashMap;

@Controller
public class IndexController {
	
	//Presently survey responses will be stored as HashMaps in an ArrayList
	private ArrayList<HashMap<String,String>> surveyResponses = new ArrayList<HashMap<String,String>>();
	
	//This puts survey data into a HashMap and adds it to the collection of responses in the ArrayList surveyResponses
	private void recordSurveyResponse(String name, String location, String language, String comments) {
		HashMap<String, String> answer = new HashMap<String, String>();
		answer.put("name", name);
		answer.put("location", location);
		answer.put("language", language);
		answer.put("comments", comments);
		surveyResponses.add(answer);	
	}
	
	//Maps to default domain
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	//maps submissions from online form, takes in survey data, and creates/updates the HTTP Session
	@RequestMapping(path="/submit", method=RequestMethod.POST)
	public String submission(HttpSession sesh, @RequestParam(value="name") String name, @RequestParam(value="location") String location, @RequestParam(value="language") String language, @RequestParam(value="comments") String comments){
		//Function call to record the survey data onto the ArrayList surveyResponses
		recordSurveyResponse(name, location, language, comments);
		
		//Redundantly survey data is added to HTTP Session
		sesh.setAttribute("yourName", name);
		sesh.setAttribute("location", location);
		sesh.setAttribute("language", language);
		sesh.setAttribute("comment", comments);
		
		//Demonstrates running record of survey responses by printing them out
		for(HashMap<String, String> form : surveyResponses) {
			System.out.println("Name: " + form.get("name"));
			System.out.println("Location: " + form.get("location"));
			System.out.println("Language: " + form.get("language"));
			System.out.println("Comments: " + form.get("comments"));
			System.out.println("\n");
		}
		//After the survey is submitted, the user's answers are displayed
		return "redirect:/result";
	}
	
	//mapping of result page
	@RequestMapping("/result")
	public String result() {
		//latest survey responses are stored in the HTTP Session and 
		//displayed on the submission.jsp page
		return "submission.jsp";
	}
	
	//getter for survey responses accessible externally for future use
	public ArrayList<HashMap<String, String>> getResponses(){
		return surveyResponses;
	}
	
	

}
