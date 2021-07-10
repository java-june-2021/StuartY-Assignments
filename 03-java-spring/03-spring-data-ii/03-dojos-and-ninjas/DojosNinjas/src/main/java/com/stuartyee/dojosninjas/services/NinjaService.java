package com.stuartyee.dojosninjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.stuartyee.dojosninjas.repositories.NinjaRepository;
import com.stuartyee.dojosninjas.models.Dojo;
import com.stuartyee.dojosninjas.models.Ninja;

@Service
public class NinjaService {
	
	NinjaRepository nRepo;

	public NinjaService(NinjaRepository nRepo) {
		this.nRepo = nRepo;
	}
	
	public List<Ninja> findAllNinjas(){
		return nRepo.findAll();
	}
	
	public Ninja findNinjaById(Long id) {
		if(nRepo.existsById(id)) {
			return nRepo.findById(id).get();
		} else {
			return null;
		}
	}
	
	public void createNinja(Ninja ninja) {
		nRepo.save(ninja);
	}
	
	public List<Ninja> findNinjasByDojo(Dojo dojo){
		return nRepo.findByDojo(dojo);
	}
	
	
	
	

}
