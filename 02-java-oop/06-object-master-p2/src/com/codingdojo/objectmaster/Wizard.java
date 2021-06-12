package com.codingdojo.objectmaster;

public class Wizard extends Human {
	
	public Wizard() {
		this.intelligence = 8;
		this.health = 50;
	}
	
	public void heal(Human patient) {
		patient.damage(-this.intelligence);
	}
	
	public void fireball(Human target) {
		target.damage(this.intelligence*3);
	}

}
