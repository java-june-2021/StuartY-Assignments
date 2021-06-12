package com.codingdojo.bank;

public class BankTest {

	public static void main(String[] args) {

		BankAccount account1 = new BankAccount();
		BankAccount account2 = new BankAccount();
		System.out.println("Total accounts: " + BankAccount.getNumOfAccounts());
		System.out.println("Total in the bank: $" + BankAccount.getBankTotal() + "\n");
		
		account1.depositChecking(20.00);
		account1.depositSavings(5000.00);
		
		account2.depositChecking(100.00);
		account2.depositSavings(200.00);
		
		System.out.println("Total in the bank: $" + BankAccount.getBankTotal() + "\n");
		
		account1.depositChecking(20.00);
		account1.depositSavings(5000.00);
		
		account2.depositChecking(100.00);
		account2.depositSavings(200.00);
		
		System.out.println("Total in the bank: $" + BankAccount.getBankTotal() + "\n");
		
		System.out.println("Checking balance for " + account1.accountNumber +": " + account1.getCheckingAmount());
		System.out.println("Checking balance for " + account1.accountNumber +": " + account1.getSavingsAmount() + "\n");
		
		account1.withrdrawChecking(20.00);
		account1.withrdrawSaving(1000.00);
		System.out.println("Total in the bank: $" + BankAccount.getBankTotal() + "\n");
		
		account2.withrdrawSaving(500.00);
		System.out.println("Total in checking and savings for account #" +account2.accountNumber + " is $" +account2.getAccountTotal());
	}

}
