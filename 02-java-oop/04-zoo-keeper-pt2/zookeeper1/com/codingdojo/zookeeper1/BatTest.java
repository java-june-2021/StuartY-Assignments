package com.codingdojo.zookeeper1;

public class BatTest {

	public static void main(String[] args) {
		Bat ghidora = new Bat();
		System.out.println("Starting energy: " + ghidora.energyLevel);
		ghidora.attackTown();
		ghidora.attackTown();
		ghidora.attackTown();
		System.out.println("It's Ghidora! Ghidora's energy is " + ghidora.energyLevel);
		ghidora.eatHumans();
		ghidora.eatHumans();
		System.out.println("Ghidora has eaten two hapless soldiers!");
		System.out.println("His energy is now " + ghidora.energyLevel);
		ghidora.fly();
		ghidora.fly();
		System.out.println("Ghidora has flown away.");
		System.out.println("Flying is exhausting, Ghidora has only " 
		+ ghidora.energyLevel + " energy left.");

	}

}
