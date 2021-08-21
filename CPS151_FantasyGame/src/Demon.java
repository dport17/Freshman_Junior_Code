/*
 * Demon.java
 * Name: Devin Porter
 * Username: porterd3
 * Assignment: 5
 * 
 * This is a superclass of the Balrog and Cyberdemon class. There is a 5% chance that it will add 50 points to
 * the damage originally inflicted from the Creature class getDamage method. 
 */
public class Demon extends Creature{
	private int totalDamage;
	public Demon(int x, int y) {
		super(x, y);
		
	}
	
	public int getDamage() {
		totalDamage=super.getDamage();
		if (rand.nextInt(100)<5) {
			cout.println("Demonic attack inflicts 50 " + " additional damage points!");
			totalDamage+=50;
		}
		return totalDamage;
	}//end getDamage
	
	public String getSpecies() {
		return "Demon";
	}//end getSpecies

}//end Demon
