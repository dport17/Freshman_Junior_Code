/*
 * Elf.java
 * Name: Devin Porter
 * Username: porterd3
 * Assignment: 5
 * 
 * This models an Elf from the whatever magical world you choose. Since the Elf has 10% chance to inflict twice as much damage as that returned to it 
 * by the getDamage method in the superclass, its getDamage method models that. Also, its getSpecies method simply returns the name of the class.
 * 
 */
public class Elf extends Creature {
	private int totalDamage;
	public Elf(int x, int y) {
		super(x,y);
	}
	public int getDamage() {
		totalDamage=super.getDamage();
		if (rand.nextInt(10)==0){
			cout.println("Magical attack inflicts /"+totalDamage+"/ addditional damage points!");
			totalDamage*=2;
		}
		return totalDamage;
	}//end getDamage
	
	public String getSpecies() {
		return "Elf";
	}//end getSpecies
}//end Elf
