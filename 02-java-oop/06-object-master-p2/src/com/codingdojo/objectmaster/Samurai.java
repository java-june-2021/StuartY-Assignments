package com.codingdojo.objectmaster;

public class Samurai extends Human {
	public static int samuraiCount = 0;
	
	public Samurai() {
		samuraiCount++;
		this.health = 200;
	}
	
	public void deathBlow(Human defender) {
		defender.damage(defender.health);
		this.health = (this.health / 2);
	}
	
	public void meditate() {
		this.health += (this.health/2);
	}
	
	public int howMany() {
		return samuraiCount;
	}

}
