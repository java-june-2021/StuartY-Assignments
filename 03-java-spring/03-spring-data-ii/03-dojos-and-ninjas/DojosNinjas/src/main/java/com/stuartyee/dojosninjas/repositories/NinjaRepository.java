package com.stuartyee.dojosninjas.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stuartyee.dojosninjas.models.Dojo;
import com.stuartyee.dojosninjas.models.Ninja;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long> {
	
	//Return all Ninjas as a list
	List <Ninja> findAll();
	
	//Find all Ninjas belonging to a particular Dojo
	List <Ninja> findByDojo(Dojo dojo);
	
	//Find a Ninja by Id
	Optional<Ninja> findById(Long id);
	
	

}
