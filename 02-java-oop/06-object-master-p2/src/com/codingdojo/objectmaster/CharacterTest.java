package com.codingdojo.objectmaster;

public class CharacterTest {

	public static void main(String[] args) {
		Samurai bob = new Samurai();
		System.out.println("Bob is a Samurai:");
		System.out.println("Health " + bob.health);
		System.out.println("Intelligence " +bob.intelligence);
		System.out.println("Stealth " + bob.stealth);
		System.out.println("Strength " + bob.strength);
		System.out.println("I count " + bob.howMany() + " Samurai on the field\n");
		
		Samurai linda = new Samurai();
		System.out.println("Linda is a Samurai:");
		System.out.println("Health " + linda.health);
		System.out.println("Intelligence " +linda.intelligence);
		System.out.println("Stealth " + linda.stealth);
		System.out.println("Strength " + linda.strength);
		System.out.println("I count " + linda.howMany() + " Samurai on the field\n");
		
		Wizard gene = new Wizard();
		System.out.println("Gene is a Wizard:");
		System.out.println("Health " + gene.health);
		System.out.println("Intelligence " +gene.intelligence);
		System.out.println("Stealth " + gene.stealth);
		System.out.println("Strength " + gene.strength +"\n");
		
		Ninja louise  = new Ninja();
		System.out.println("Louise is a Ninja:");
		System.out.println("Health " + louise.health);
		System.out.println("Intelligence " +louise.intelligence);
		System.out.println("Stealth " + louise.stealth);
		System.out.println("Strength " + louise.strength +"\n");		
		
		Human tina = new Human();
		System.out.println("Tina couldn't decide on a class:");
		System.out.println("Health " + tina.health);
		System.out.println("Intelligence " +tina.intelligence);
		System.out.println("Stealth " + tina.stealth);
		System.out.println("Strength " + tina.strength +"\n");
		
		bob.deathBlow(tina);
		System.out.println("Bob hits Tina with a deathblow!");
		System.out.println("\"I'm okay!\" she says, but she's not.");
		System.out.println("Tina's health is " + tina.health);
		System.out.println("Bob's health is " + bob.health + "\n");
		
		gene.heal(tina);
		System.out.println("Gene heals Tina!");
		System.out.println("Tina's health is now " + tina.health + "\n");
		
		linda.meditate();
		System.out.println("Linda sits and meditates.");
		System.out.println("Linda's health is " + linda.health + "\n");
		
		louise.steal(bob);
		System.out.println("Louise steals life from Bob!");
		System.out.println("Louise's health is at " + louise.health);
		System.out.println("Bob's health is at " + bob.health + "\n");
		
		tina.attack(linda);
		System.out.println("Tina attacks Linda");
		System.out.println("Linda's health is now " + linda.health + "\n");
		
		bob.meditate();
		System.out.println("\"I'm just going to lie here.\" Bob's health is at " + bob.health + "\n");
		
		gene.fireball(bob);
		System.out.println("Gene fireballs Bob");
		System.out.println("Bob's health is now at " + bob.health + "\n");
		
		linda.deathBlow(gene);
		System.out.println("\"Hey! No playing with fire!\" an Linda strikes Gene with a deathblow");
		System.out.println("Gene's health is at " + gene.health);
		System.out.println("Linda's health is at " + linda.health + "\n");
		
		louise.runAway();
		System.out.println("Louise bravely runs away");
		System.out.println("Louise's health is at " + louise.health + "\n");
		
		tina.attack(bob);
		System.out.println("Tina attacks Bob");
		System.out.println("Bob's health is " + bob.health + "\n");
		
		bob.attack(tina);
		System.out.println("\"Oh yeah?\" and Bob attack's Tina");
		System.out.println("Tina's health is at " + tina.health + "\n");
		
		System.out.println("Gene is still dead \n");
		
		linda.deathBlow(tina);
		System.out.println("Linda strikes Tina with a deathblow");
		System.out.println("Tina's dead with a health at " +tina.health);
		System.out.println("Linda' health is at " +linda.health + "\n");
		
		System.out.println("Louise ran away earlier. \n");
		
		System.out.println("Bob and Linda are the only ones left");
		System.out.println("\"We win, alright!\"\n");
		
		System.out.println("The burger of the day is the \"Sepu-Cucumber Burger\" made with teriyaki, sriracha and cucumber");
	}

}
