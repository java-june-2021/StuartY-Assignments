package com.codingdojo.zookeeper1;

public class GorillaTest {

	public static void main(String[] args) {
		
		Gorilla bubba = new Gorilla();
		System.out.println("Starting energy level:");
		bubba.displayEnergyLevel(); // Gorilla class inheritance works
		
		bubba.throwSomething();
		bubba.throwSomething();
		bubba.throwSomething();
		System.out.println("The gorilla's energy is now at:");
		bubba.displayEnergyLevel();
		bubba.eatBananas();
		bubba.eatBananas();
		System.out.println("This gorilla is refreshed, its new energy is at:");
		bubba.displayEnergyLevel();
		bubba.climb();
		System.out.println("That was a bit of hard work, its energy is at:");
		bubba.displayEnergyLevel();
	}

}
