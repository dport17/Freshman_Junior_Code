/*
 * Resistor.java
 * Name: Devin Porter
 * Username: porterd3
 * Assignment: 3
 * 
 * This class represents a resistor with a defined nominal resistance and tolerance. It contains a constructor which accepts values
 * for the nominal resistance and tolerance, then produces an "actualValue" in the acceptable range. This is a pseudo random value 
 * in this range.
 * 
 * The class also provides public methods that return to the Main1 class the values of the nominal, tolerance, and actualValue.
 * 
 *
 */
import java.util.*;
public class Resistor {
	//initialize the data fields. 
	private double nominal;
	private double tolerance;
	private double actualValue;
	
	public Resistor(double nom, double tol) {
		nominal=nom;
		tolerance=tol;
		
		//define ends of range
		double min=nominal-(nominal*(tolerance/100));
		double max=nominal+(nominal*(tolerance/100));
		
		//define distance between top and bottom of range.
		double distance=max-min;
		actualValue=(Math.random()*((distance)))+min;
	}
	
	//return the nominal resistance
	public double getNomVal() {
		return nominal;
	}//end getNomVal
	
	//return the tolerance
	public double getTolVal() {
		return tolerance;
	}//end getTolVal
	
	//return the actual value
	public double getActualVal() {
		return actualValue;
	}//end getActualVal
	
}//end Resistor
