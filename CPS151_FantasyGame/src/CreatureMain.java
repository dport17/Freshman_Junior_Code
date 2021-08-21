/*
 * CreatureMain.java
 * Name: Devin Porter
 * Username: porterd3
 * Assignment: 5
 * 
 * 
 * This program tests the Creature class and all of its subclasses. In this case, all it is meant to do is ensure that
 * the getDamage and getSpecies methods are working correctly in each class. 
 * 
 * 
 */
import java.util.ArrayList;
public class CreatureMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Creature evictus=new Balrog(54, 54);
		Creature Devin = new Human(100, 67);
		Creature Legolas=new Elf(100, 100);
		
		ArrayList<Creature> x=new ArrayList<Creature>();
		x.add(evictus);
		x.add(Devin);
		x.add(Legolas);
		x.add(new Cyberdemon(34,34));
		x.add(new Human(50,67));
		for (int i=0; i<x.size(); i++) {
			System.out.println(x.get(i).getSpecies());
			for(int j=0; j<15;j++) {
				System.out.println("---------------------------------------------------------");
				x.get(i).getDamage();
			}
			System.out.println("---------------------------------------------------------");
		}//end for block
		
	}//end main

}//end CreatureMain
