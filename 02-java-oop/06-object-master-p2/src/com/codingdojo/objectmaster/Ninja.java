package com.codingdojo.objectmaster;

public class Ninja extends Human {
	
	public Ninja() {
		this.stealth = 10;
	}
	
	public void steal(Human defender) {
		defender.damage(this.stealth);
		this.health += this.stealth;
	}
	
	public void runAway() {
		this.health -= 10;
	}
}
