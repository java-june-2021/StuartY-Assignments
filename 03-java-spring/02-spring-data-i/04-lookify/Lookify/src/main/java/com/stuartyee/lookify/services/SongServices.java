package com.stuartyee.lookify.services;

import org.springframework.stereotype.Service;

import com.stuartyee.lookify.repositories.SongRepository;
import com.stuartyee.lookify.models.Song;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

//Annotation as a Service
@Service
public class SongServices {
	
	//Create repository object
	private SongRepository sRepo;

	//an instance Song Repository object generated in object constructor	
	public SongServices(SongRepository sRepo) {
		this.sRepo = sRepo;
	}
	
	public Song findSongById(Long id) {
		Optional<Song> song = sRepo.findById(id);
		if(song.isPresent()) {
			return song.get();
		} else {
			return null;
		}
	}
	
	public List<Song> allSongs() {
		return sRepo.findAll();
	}
	
	public Song createSong(Song song) {
		return sRepo.save(song);
	}
	
	public List<Song> searchByArtist(String artist){
		return sRepo.searchByArtistContaining(artist);
	}
	
	public void editSong(Long id, Song song) {
		if(sRepo.existsById(id)) {
			sRepo.save(song);
		}
	}
	
	public void deleteSong(Long id) {
		if(sRepo.existsById(id)) {
			sRepo.deleteById(id);
		}
	}
	
	public Song[] topTen (){
		List<Song> allSongs = sRepo.findAll();
		
		//Using sort function and defining a custom comparator to check Song.rating
		allSongs.sort(new Comparator<Song>() {
			//Overriding comparator
			@Override
			public int compare(Song s1, Song s2) {
				if(s1.getRating() == s2.getRating()) {
					return 0;
				}
				return (s1.getRating() < s2.getRating())? 1 : -1;
			}
		});
		
		Song topTen[];
		topTen = new Song[10];
		for(int i = 0; i < 10; i++) {
			topTen[i] = allSongs.get(i);
		}
		return topTen;			
	}

		

}
