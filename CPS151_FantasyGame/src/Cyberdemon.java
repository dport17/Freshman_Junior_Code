/*
 * Cyberdemon.java
 * Name: Devin Porter
 * Username: porterd3
 * Assignment: 5
 * 
 * This models a Cyberdemon from the game Doom. Since the cybersemon has no special features itself, it gets its damage 
 * value from the Creature class and overrides the getSpecies method to return the name of the class. 
 * 
 */
public class Cyberdemon extends Demon {
	public Cyberdemon(int x, int y) {
		super(x,y);
	}
	public int getDamage() {
		return super.getDamage();
	}
	public String getSpecies() {
		return "Cyberdemon";
	}
}
