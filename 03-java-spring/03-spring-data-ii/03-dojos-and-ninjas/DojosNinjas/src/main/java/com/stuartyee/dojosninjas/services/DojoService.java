package com.stuartyee.dojosninjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stuartyee.dojosninjas.models.Dojo;
import com.stuartyee.dojosninjas.repositories.DojoRepository;

@Service
public class DojoService {
	
	DojoRepository dRepo;

	public DojoService(DojoRepository dRepo) {
		this.dRepo = dRepo;
	}
	
	public List<Dojo> findAllDojos(){
		return dRepo.findAll();
	}
	
	public void createDojo(Dojo dojo) {
		dRepo.save(dojo);
	}
	
	public Dojo findByDojoId(Long id) {
		if(dRepo.existsById(id)) {
			return dRepo.findById(id).get();
		} else {
			return null;
		}
	}
	
	

}
