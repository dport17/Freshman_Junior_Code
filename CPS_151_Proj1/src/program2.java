/*
 * program2.java
 * Name: Devin Porter
 * Username: porterd3
 * Assignment: 1
 * 
 * This program initializes two array lists, one of type Integer and another of type String. 
 * It passes these to a method namesOfBestCustomers, which has the user populate the array lists with the name of each customer in 
 * the string list and the amount they spent in the integer list. 
 * 
 * Next, the program passes the array list of purchase amount (named amountSpent) to a method findLargest sale. This program 
 * learns from the user how many names to display (topN), and then sorts the array list of purchase amounts from least to most, and
 * then reverses the order to create a list of the purchase amounts from most to least. If topN is greater than the amount of 
 * customers, then the program simply redefines topN to be the total amount of customers and proceeds. 
 * 
 * Each element in this list, up to and including the element that is at the position topN-1, is compared to the ORIGINAL, 
 * USER-DEFINED list of purchase amounts, in order to identify at what position each element in the sorted array exists in the
 * original array. The program then inputs each of these positions, in order of most to least spent, into a new list. This list
 * is returned to the namesOfBestCustomers method, which loops through that array to identify which customers are at those 
 * positions in the user-defined list of customer names. 
 * 
 * This list of customers is finally sent to the main method, which made the original call, and the program loops through each
 * of these names, printing them, along with their rank, based on how great their purchase amount was. 
 * 
 * Bug report: If the user inputs something invalid, they will need to restart the entire process of populating the lists. Also, anytime the
 * user enters 0, the population process will terminate immediately, and ask how many customers they would like to output. 
 */
import java.util.*;

public class program2 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		ArrayList<String> customers=new ArrayList<String>();
		
		ArrayList<Double> amountSpent=new ArrayList<Double>();
		
		try {
			
		ArrayList<String> bestCustomers=namesOfBestCustomers(customers,amountSpent);
		
		
		int k=0;
		for (String element:bestCustomers) {
			System.out.println(k+1 +". "+ element);
			k++;
		}
		
		}
		catch(Exception e) {
			System.out.println("Something went wrong. Please re-run the system and try again.");
		}
		
	}//end main
	
	public static ArrayList<String> namesOfBestCustomers(ArrayList<String> customers, ArrayList<Double> amountSpent)throws InputMismatchException 
	{
		
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
		
		
		//sort the array
		ArrayList <Double> sortedAmountSpent=new ArrayList<Double>(amountSpent);
		Collections.sort(sortedAmountSpent);
		
		//output list contents
		System.out.println();
		System.out.print("Customers: ");
		System.out.println(customers);
		System.out.print("Spent: ");
		System.out.println(amountSpent);
		
		//find index of best customer
		ArrayList<Integer> indexesOfBestCustomers=findLargestSale(customers, amountSpent);
		
		//initialize array of top names
		ArrayList<String> names=new ArrayList<String>();
		
		//loop through top customer indexes, populate names with that. 
		for (int j=0;j<indexesOfBestCustomers.size();j++) {
			String cust=customers.get(indexesOfBestCustomers.get(j));
			names.add(cust);
		}//end loop
		return names;
		
	}//end namesOfBestCustomers
	
	//find index of greatest sales in the user-defined amountSpent list. 
	public static ArrayList<Integer> findLargestSale(ArrayList<String>custs, ArrayList<Double> a) {
		Scanner in=new Scanner(System.in);
		
		//get topN
		System.out.println("How many of the top customers would you like to display?");
		int topN=in.nextInt();
		if(topN>a.size())
		{		
			topN=a.size();
		}
		//make new lists
		ArrayList <Integer> indexes=new ArrayList<Integer>();
		ArrayList<Double>sortedSales=new ArrayList<Double>(a);
		Collections.sort(sortedSales);
		Collections.reverse(sortedSales);
		
		//loop through lists, identify indexes of top sales amounts in original 
		for(int i=0;i<topN;i++) {
			for(int j=0; j<a.size();j++) {
				if(sortedSales.get(i)==a.get(j)) {
					indexes.add(j);
				}
			}//end inner for
		}//end for block
		
		
		return indexes;
	}//end findLargestSale
}//end program2
