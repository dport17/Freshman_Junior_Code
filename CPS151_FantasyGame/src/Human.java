/*
 * Human.java
 * Name: Devin Porter
 * Username: porterd3
 * Assignment: 5
 * 
 * This program models a human. It simply allows the human to inflict damage and returns the name of the class 
 * in getSpecies. 
 */
public class Human extends Creature {
	public Human(int x, int y) {
		super(x,y);
	}
	
	public int getDamage() {
		return super.getDamage();
	}
	
	public String getSpecies() {
		return "Human";
	}
}//end Human
