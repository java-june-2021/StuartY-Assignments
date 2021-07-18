package com.stuartyee.dojooverflow.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stuartyee.dojooverflow.models.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {
	
	public List<Tag> findAll();
	public Optional<Tag> findById(Long id);
	public Tag findBySubject(String search);
	

}
