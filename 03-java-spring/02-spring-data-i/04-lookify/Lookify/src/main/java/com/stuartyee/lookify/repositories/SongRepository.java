package com.stuartyee.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.stuartyee.lookify.models.Song;

@Repository
public interface SongRepository extends CrudRepository<Song, Long> {

		//Retrieves all as a List
		List<Song> findAll();
		
		//query by artist name
		List<Song> searchByArtistContaining(String artist);
	
}
