package com.codingdojo.objectmaster;

public class Human {
	int strength = 3;
	int stealth =3;
	int intelligence = 3;
	int health = 100;
	
	public void attack(Human defender) {
		defender.health = defender.health - this.stealth;
	}

}
