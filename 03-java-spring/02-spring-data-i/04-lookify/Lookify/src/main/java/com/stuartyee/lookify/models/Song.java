package com.stuartyee.lookify.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity //MySQL Record
@Table(name="songs") //MySQL Table
public class Song {
	//Creating MySQL ID
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	//Song title
	@Column
	@Size(min=5, max=30)
	@NotBlank //preventing white spaces
	private String title; 

	@Column
	@Size(min=5, max=30)
	@NotBlank //Preventing white spaces from being counted
	private String artist; 
	
	@Column
	@Min(1)
	@Max(10)
	private Integer rating;

	public Song() { //Java Beans empty constructor
	}

	public Song(@Size(min = 5, max = 30) @NotBlank String title, @Size(min = 5, max = 30) @NotBlank String artist,
			@Min(1) @Max(10) Integer rating) {
		super();
		this.title = title;
		this.artist = artist;
		this.rating = rating;
	}
	
	// Getters and setters
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}
	
	
	
	
	
	
	
}
