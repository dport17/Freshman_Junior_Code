/*
 * BankAccount.java
 * Name: Devin Porter
 * Username: porterd3
 * Assignment: 3
 * 
 * This program is a copy of the BankAccount class created in chapter 8 of BJLO. It will be used by the Portfolio class to alter
 * the balances of a savings object of type BankAccount and a checking object of the same type. 
 */
public class BankAccount {
	private double balance;
	private double transAmount;
	public BankAccount() {
		balance=0;
		transAmount=0;
	}
	public BankAccount(double initialBalance) {
		balance=initialBalance;
	}
	public void deposit(double amount){  
		balance = balance + amount;
		transAmount++;
	}
	public void addInterest(double rate){  
		double amount=balance*rate/100;
		balance+=amount;
	}
	public void withdraw(double amount){ 
		final double PENALTY=10;
		if (amount>balance) {
			balance=balance-PENALTY;
		}
		else {
			balance=balance-amount;
			transAmount++;
		}
	}
	public double getBalance() {
		return balance;
	}
	double deductTransFee() {
		if(transAmount>5) {
			return balance-(transAmount-5);
		}
		return balance;
	}//end deductTransFee
}//end BankAccount
