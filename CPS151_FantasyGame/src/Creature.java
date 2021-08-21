/*
 * Creature.java 
 * Name: Devin Porter
 * Username: porterd3
 * Assignment: 5
 * 
 * This class models a Creature object, and has subclasses Demon, Human, and Elf. It initializes the Creature's
 * strength and hitpoints value, and allows the Demon, Human, or Elf to inflict a damage value between 1 and
 * the Creature's strength value in the getDamage method. The getSpecies method simply returns the name of the class. 
 */
import java.io.PrintStream; 
import java.util.*;

public class Creature {
	    private int strength;   // How much damage we can inflict
	    private int hitpoints;  // How much damage we can sustain

	    final PrintStream cout = System.out;
	    final Random rand = new Random();
	   
	    String getSpecies() // Returns type of species
	    {
	        return "Creature";

	    }
	   
	    public Creature(int newStrength, int newHit)
	    // Initialize creature to new type, strength, hit points
	    {
	        strength=newStrength; hitpoints=newHit;
	    }

	    // Also add appropriate getter and setter methods
	    // for type, strength, and hit points

	    /*
	        The getDamage( ) method outputs and returns the damage this creature can inflict in one round of combat.
	        The rules for calculating the damage are as follows:
	            *    Every creature inflicts damage that is a random number r, where 0 < r <= strength.
	            *    Demons have a 5% chance of inflicting a demonic attack which is an additional 50 damage points.  Balrogs and Cyberdemons are demons.
	            *    With a 10% chance elves inflict a magical attack that doubles the normal amount of damage.
	            *    Balrogs are very fast, so they get to attack twice.
	     */
	    public int getDamage() // Returns amount of damage this creature
	                           // inflicts in one round of combat
	    {
	      int damage;

	      // All creatures inflict damage which is a
	      // random number up to their strength
	      damage = rand.nextInt(strength) + 1;
	      cout.println(getSpecies() + " attacks for " + damage + " points!");

	      // Demons can inflict damage of 50 with a 5% chance
	     /* if ((type == 2) || (type == 1))
	         if (rand.nextInt(100) < 5)
	         {
	            damage = damage + 50;
	            cout.println("Demonic attack inflicts 50 " + " additional damage points!");
	         }

	      // Elves inflict double magical damage with a 10% chance
	      if (type == 3)
	      {
	         if (rand.nextInt(10)==0)
	         {
	            cout.println("Magical attack inflicts " + damage + " additional damage points!");
	            damage = damage * 2;
	         }
	      }

	      // Balrogs are so fast they get to attack twice
	      if (type == 2)
	      {
	          int damage2 = rand.nextInt(strength) + 1;
	          cout.println("Balrog speed attack inflicts " + damage2 + " additional damage points!");
	          damage = damage + damage2;
	      }*/
	      return damage;
	    } // end getDamage method

}
