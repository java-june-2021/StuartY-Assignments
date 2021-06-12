package com.codingdojo.bank;

import java.util.Random;

public class BankAccount {
	public String accountNumber;
	private double checkingAmount;
	private double savingsAmount;
	private static int numberOfAccounts;
	private static double totalAllAccounts;
	
	public BankAccount() {
		this.accountNumber = createAccountNumber();
		numberOfAccounts++;
		System.out.println("Congratulations on opening a new account!");
		System.out.println("Your account number is: " + this.accountNumber + "\n");
	}
	
	public static int getNumOfAccounts() {
		return numberOfAccounts;
	}
	
	public String getAccountNumber() {
		return this.accountNumber;
	}
	
	public double getCheckingAmount() {
		return this.checkingAmount;
	}
	
	public double getSavingsAmount() {
		return this.savingsAmount;
	}
	
	public double getAccountTotal() {
		double balance;
		balance = this.getCheckingAmount() + this.getSavingsAmount();
		return balance;
	}
	
	public void depositChecking(double deposit) {
		this.checkingAmount += deposit;
		totalAllAccounts += deposit;
		System.out.println("$" + deposit + "successuflly deposited into Account#" +this.accountNumber);
		System.out.println("Current balance is $" + this.checkingAmount + "\n");
	}
	
	public void depositSavings(double deposit) {
		this.savingsAmount += deposit;
		totalAllAccounts += deposit;
		System.out.println("$" + deposit + " successuflly deposited into Account#" +this.accountNumber);
		System.out.println("Current balance is $" + this.savingsAmount + "\n");
	}
	
	public void withrdrawChecking(double amount) {
		if(amount > this.checkingAmount) {
			System.out.println("Unfortunately you have insuficient funds.");
			System.out.println("You are requesting $" + amount);
			System.out.println("However the balance in this checking account is only $" +this.checkingAmount);
		} else {
			this.checkingAmount -= amount;
			totalAllAccounts -= amount;
			System.out.println("You have withdrawn $" + amount + " from this checking account.");
			System.out.println("Your new balance is $" + this.checkingAmount);
		}
	}
	
	public void withrdrawSaving(double amount) {
		if(amount > this.savingsAmount) {
			System.out.println("Unfortunately you have insuficient funds.");
			System.out.println("You are requesting $" + amount);
			System.out.println("However the balance in this savings account is only $" +this.savingsAmount);
		} else {
			this.savingsAmount -= amount;
			totalAllAccounts -= amount;
			System.out.println("You have withdrawn $" + amount + " from this savings account.");
			System.out.println("Your new balance is $" + this.savingsAmount);
		}
	}
	
	public static double getBankTotal() {
		return totalAllAccounts;
	}
	
	private static String createAccountNumber() {
		Random rand = new Random();
		String strArr[];
		strArr = new String[10];
		for(int i = 0; i < 10; i++) {
			String digit = String.valueOf(rand.nextInt(9));
			strArr[i] = digit;
		}
		String accountNum = strArr[0] + strArr[1] + strArr[2] + strArr[3] +
				strArr[4] + strArr[5] + strArr[6] + strArr[7] + strArr[8] +
				strArr[9];
		return accountNum;
	}

}
