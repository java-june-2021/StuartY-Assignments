package com.stuartyee.dojooverflow.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.stuartyee.dojooverflow.models.Tag;
import com.stuartyee.dojooverflow.repositories.TagRepository;

@Service
public class TagService {
	
	private TagRepository tRepo;

	public TagService(TagRepository tRepo) {
		this.tRepo = tRepo;
	}
	
	//Based on input will either create a new tag or use an existing one
	public Tag findOrCreate(String entryRaw) {
		String entry = entryRaw.toLowerCase();
		if(tRepo.findBySubject(entry) != null) {
			return tRepo.findBySubject(entry);
		} else {
			Tag newTag = new Tag();
			newTag.setSubject(entry);
			tRepo.save(newTag);
			return newTag;
		}
	}
	
	//Takes the raw input and separates by comma
	public List<Tag> processTag(String submission) {
		//create an array of strings separated by commas
		String[] arrTags = submission.split(",");
		for(int i = 0; i < arrTags.length; i++) {
			String tag = arrTags[i];
			String trimmed = tag.trim();
			arrTags[i] = trimmed; //get rid of white space if any
		}
		if (arrTags.length > 3) {
			return null;  //returning a null value if there are more than 3 tags will kick an error
		} else {
			List<Tag> finalTags = new ArrayList<Tag>();
			for(String rawTag : arrTags) {
				Tag tag = findOrCreate(rawTag);
				finalTags.add(tag);
			}
			return finalTags; //the returned tags in the list will be added to the question
		}
	}
	
	

}
