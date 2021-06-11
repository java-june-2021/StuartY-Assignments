package com.codingdojo.zookeeper1;

public class Bat extends Mammal {
	public Bat() {
		energyLevel = 300;
	}
	
	public void fly() {
		System.out.println("Whooosh! The bat is in flight!");
		this.energyLevel = this.energyLevel - 50;
	}
	
	public void eatHumans() {
		System.out.println("Look out!! It's going to eat somebody!");
		this.energyLevel = this.energyLevel + 25;
	}
	
	public void attackTown() {
		System.out.println("Oh no! A town is under attack! It's on fire!");
		this.energyLevel = this.energyLevel - 100;
	}

}
