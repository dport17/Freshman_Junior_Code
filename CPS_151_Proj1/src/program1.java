/*
 * program1.java
 * Name: Devin Porter
 * Username: porterd3
 * Assignment: 1
 * 
 * 
 * This program initializes two array lists, one of type Integer and another of type String. 
 * It passes these to a method nameOfBestCustomer, which has the user populate the array lists with the name of each customer in 
 * the string list and the amount they spent in the integer list. 
 * 
 * The list of purchase amounts is passed to a method which returns the position of the highest amount in the list. This position
 * corresponds to the person who spent that amount, and the nameOfBestCustomer method stores this name and returns it to the main method,
 * which outputs the name of the best customer. 
 * 
 * Bug report: If the user inputs something invalid, they will need to restart the entire process of populating the lists. Also, anytime the
 * user enters 0, the population process will terminate immediately and name the best customer up to that point. 
 */
import java.util.*;
public class program1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		ArrayList<String> customers=new ArrayList<String>();
		
		ArrayList<Double> amountSpent=new ArrayList<Double>();
		
		try {
		
		String bestCustomer=nameOfBestCustomer(customers,amountSpent);
		
		
		System.out.println();
		System.out.println("Our best customer is "+bestCustomer+"!");
		
		}catch(Exception e) {
			System.out.println("Something went wrong: "+e);
		}
	}//end main
	public static String nameOfBestCustomer(ArrayList<String> customers, ArrayList<Double> amountSpent) {
		//have user populate lists
		Scanner in = new Scanner (System.in);
		
		//initialize
		int sentinelNum=0;
		String sentinelString="0";
		double value=1;
		String name="name";
		int i=0;
		
		//conditions
		while((value!=sentinelNum)&&(!name.equals(sentinelString))) {
			
			//process
			System.out.println("What is the next customer's name? (Enter 0 to quit.)");
			name=in.next();
			if (name.equals(sentinelString)) {
				break;
			}
			System.out.println("How much did "+name+" spend? (Enter 0 to quit.)");
			value=in.nextDouble();
			if (value<0) {
				InputMismatchException ex=new InputMismatchException();
				throw ex;
			}
			
			//add input to lists
			customers.add(i, name);
			amountSpent.add(i, value);
			
			//update
			i++;
		}//end loop
		
		//output list contents
		System.out.println();
		System.out.println(customers);
		System.out.println(amountSpent);
		
		//find index of best customer
		int indexOfBestCustomer=findLargestSale(amountSpent);
		
		return customers.get(indexOfBestCustomer);
	}//end nameOfBestCustomer
	
	//find index of greatest sales
	public static int findLargestSale(ArrayList<Double> a) {
		double maxSale=a.get(0);
		int maxSaleIndex=0;
		for(int i=1;i<a.size();i++) {
			if(a.get(i)>maxSale) {
				maxSale=a.get(i);
				maxSaleIndex=i;
			}//end if
		}//end for loop
		
		return maxSaleIndex;
	}//end findLargestSale

}//end program1
