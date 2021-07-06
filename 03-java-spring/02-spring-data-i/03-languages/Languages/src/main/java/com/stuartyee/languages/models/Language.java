package com.stuartyee.languages.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity //Establishes this object as a representation of a MySQL record
@Table(name="languages") //Connects to MySQL table
public class Language {
	
	//Annotations to generate MySQL ID
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column
	@Size(min=3, max=20)
	@NotBlank
	private String name;
	
	@Column // TODO deprecated?
	@Size(min=3, max=20)
	@NotBlank
	private String creator;
	
	@Column
	@NotBlank
	private String version;

	// Empty constructor for Java Beans compliance for MVC forms
	public Language() {
	}

	// Standard constructor for new records
	public Language(@Size(min = 3, max = 20) @NotBlank String name, @Size(min = 3, max = 20) @NotBlank String creator,
			@NotBlank String version) {
		this.name = name;
		this.creator = creator;
		this.version = version;
	}
	
	//Begin getters and setters
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
	
	
	

}
