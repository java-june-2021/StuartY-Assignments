package com.codingdojo.objectmaster;

public class HumanTest {

	public static void main(String[] args) {
		Human reginald = new Human();
		Human alonzo = new Human();
		
		System.out.println("Reginald attacks Alonzo!");
		reginald.attack(alonzo);
		System.out.println("Alonzo's health is " + alonzo.health);
		System.out.println("Reginald is at " + reginald.health);

	}

}
