/*
 * Portfolio.java
 * Name: Devin Porter
 * Username: porterd3
 * Assignment: 3
 * 
 * This class edits the values of a checking and savings account in a Portfolio object. It can transfer money from one account to
 * another, deposit money in one account, or withdraw money from one account. Each time, it alters the amount of money in each 
 * account. It uses a class BankAccount with previously defined methods to withdraw, deposit, and add interest to a BankAccount object.
 * 
 * This class utilizes the public methods in the BankAccount class to affect the checking and savings accounts. 
 */
import java.util.*;
public class Portfolio {
	
	 
		BankAccount checking=new BankAccount();
		BankAccount savings=new BankAccount();
		public void deposit(double amount, String account) {
			if(account=="S") {
				savings.deposit(amount);
			}
			else if (account=="C"){
				checking.deposit(amount);
			}
			else {
				InputMismatchException ex=new InputMismatchException();
				throw ex;
			}
		}//end deposit
		
		public void withdraw(double amount, String account) {
			if(account=="S") {
				savings.withdraw(amount);
			}
			else if (account=="C"){
				checking.withdraw(amount);;
			}
			else {
				InputMismatchException ex=new InputMismatchException("Invalid account input.");
				throw ex;
			}
		}//end withdraw
		
		public void transfer(double amount, String account) {
			if(account=="S") {
				savings.withdraw(amount);
				checking.deposit(amount);
			}
			else if (account=="C"){
				checking.withdraw(amount);
				savings.deposit(amount);
			}
			else {
				InputMismatchException ex=new InputMismatchException("Invalid account input.");
				throw ex;
			}
		}//end transfer
		
		public double getBalance(String account) {
			if(account=="S") {
				return savings.getBalance();
			}
			else if (account=="C"){
				return checking.getBalance();
			}
			else {
				InputMismatchException ex=new InputMismatchException("Invalid account input.");
				throw ex;
			}
		}
	
	
	
}//end Portfolio
