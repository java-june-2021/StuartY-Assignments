package com.stuartyee.books.models;

import java.util.Date; // this may or may not be the right package.

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="books")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id; //SQL record ID auto-incrementing 
 
	@Column
	@Size(min = 2, max = 200)
	private String title; //Book title
 
	@Column
	@Size(min = 5, max = 200)
	private String description; //Description of book
 
	@Column
	@Size(min = 3, max = 40)
	private String language; //Language book is written in
 
	@Column
	@Min(100)
	private int numberOfPages;
 
 // This will not allow the createdAt column to be updated after creation
	@Column(updatable=false)
	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	private Date createdAt; 
	
	@Column
	@DateTimeFormat(pattern = "MM/dd/yyyy HH:mm:ss")
	private Date updatedAt;

	public Book() {
	}

	public Book(Long id, @Size(min = 2, max = 200) String title, @Size(min = 5, max = 200) String description,
			@Size(min = 3, max = 40) String language, @Min(100) int numberOfPages, Date createdAt, Date updatedAt) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.language = language;
		this.numberOfPages = numberOfPages;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	

	public Book(@Size(min = 2, max = 200) String title, @Size(min = 5, max = 200) String description,
			@Size(min = 3, max = 40) String language, @Min(100) int numberOfPages) {
		this.title = title;
		this.description = description;
		this.language = language;
		this.numberOfPages = numberOfPages;
	}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

	
	
}

