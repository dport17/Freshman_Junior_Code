/*
 * Balrog.java
 * Name: Devin Porter
 * Username: porterd3
 * Assignment: 5
 * 
 * This models a Balrog from the Lord of the Rings. Since the Balrog can attack twice, it adds damage to 
 * whatever damage amount it receives from the Demon and Creature classes. It also simply returns the name of the class 
 * when getSpecies is called. 
 */
public class Balrog extends Demon {
	private int totalDamage;
	private int strength;
	public Balrog(int x, int y) {
		super(x,y);
		this.strength=x;
	}
	
	@Override
	public String getSpecies() {
		return "Balrog";
	}
	
	@Override
	public int getDamage() {
		totalDamage=super.getDamage();
		int damage2=rand.nextInt(strength)+1;
		cout.println("Balrog speed attack inflicts " + damage2 + " additional damage points!");
		totalDamage+=damage2;
		return totalDamage;
	}
}//end Balrog
