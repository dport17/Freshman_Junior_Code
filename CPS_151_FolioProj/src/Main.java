/*
 * Main.java
 * Name: Devin Porter
 * Username: porterd3
 * Assignment: 3
 * 
 * This Main class tests the Portfolio class by calling its public deposit, withdraw, and transfer methods and displaying what 
 * remains in the portfolio. 
 */
public class Main {
	
	public static void main(String[] args) {
		
		    Portfolio folio = new Portfolio(); // start with a new Portfolio
		    
		    folio.deposit(10000, "S"); // deposit $10,000.00 in savings
		    folio.transfer(1500, "S"); // transfer $1,500.00 to checking
		    
		    // get the savings balance (should be $8,500.00)
		    System.out.println("\tsavings: " + folio.getBalance("S"));
		    // get the checking balance (should be $1,500.00)
		    System.out.println("\tchecking: " + folio.getBalance("C"));
		   
		    System.out.println("---------------------------------------------------------------------");
		   
		    System.out.println(folio); // display the Portfolio (calls toString())
		   
		    System.out.println("---------------------------------------------------------------------");
		   
		    folio.withdraw(500, "C"); // withdraw $500.00 from checking
		    folio.transfer(1000, "S"); // transfer $1,000.00 to checking
		    folio.deposit(3000, "S"); // deposit $3,000.00 in savings
		   
		    // get the savings balance (should be $10,500.00)
		    System.out.println("\tsavings: " + folio.getBalance("S"));
		    // get the checking balance (should be $2,000.00)
		    System.out.println("\tchecking: " + folio.getBalance("C"));
		   
		    System.out.println("---------------------------------------------------------------------");
		   
		    System.out.println(folio); // display the Portfolio (calls toString())
	
	} // end main
}
