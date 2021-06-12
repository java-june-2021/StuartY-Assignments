package com.codingdojo.objectmaster;

public class Human {
	int intelligence = 3;
	int stealth = 3;
	int strength = 3;
	int health = 100;
	
	public void attack(Human defender) {
		defender.damage(this.strength);
	}
	
	public void damage(int amount) {
		this.health = this.health - amount;
	}

}
