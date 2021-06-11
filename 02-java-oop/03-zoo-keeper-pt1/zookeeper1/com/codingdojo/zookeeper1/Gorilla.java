package com.codingdojo.zookeeper1;

public class Gorilla extends Mammal {
	
	public void throwSomething() {
		System.out.println("This gorilla has thrown poo!");
		this.energyLevel = this.energyLevel -5;
		
	}
	
	public void eatBananas() {
		System.out.println("This gorilla has enjoyed a delicious banana and is very content!");
		this.energyLevel = this.energyLevel + 10;
	}
	
	public void climb() {
		System.out.println("This gorilla climbed up a tree.");
		this.energyLevel = this.energyLevel - 10;
	}
	

}
