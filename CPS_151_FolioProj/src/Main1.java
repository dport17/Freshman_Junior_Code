/*
 * Main1.java
 * Name: Devin Porter
 * Username: porterd3
 * Assignment: 3
 * 
 * This is a main method to test the Resistor class. It provides 10 actual values of a resistor with a nominal resistance of 330 
 * and a tolerance of 10 percent, and displays them in a numbered list. 
 * 
 */
public class Main1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++) {
			Resistor resistor=new Resistor(330, 10);
			resistor.getNomVal();
			resistor.getTolVal();
			System.out.println(i+1+". "+resistor.getActualVal());
		}//end loop
	}//end main

}//end Main1
