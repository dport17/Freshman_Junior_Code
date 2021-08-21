/*
 * UserMain.java 
 * Name: Devin Porter 
 * Username: porterd3
 * Assignment: 8
 * 
 * This program is meant to test the User class. It does so by populating a HashMap with the string name of a User as a key and the corresponding User
 * as the value of it. For each of those Users, it adds other Users to a list of friends for each of the users in that HashMap. 
 * 
 * After the HashMap and the Friends list are populated, the program allows the user to input a User's name as a string. It then outputs each of the 
 * User's friends, as well as the friends of those friends, but not the friends of those friends. 
 * 
 * 
 */
import java.util.*;
import java.io.*;
public class UserMain {
	
	static Map<String, User> x= new HashMap<String, User>();
	
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		Scanner fileScanner=new Scanner(new File("network.txt"));
		
		
		
		while(fileScanner.hasNextLine()) {
			System.out.println("-----------------------------");
			String name=fileScanner.next();

			if(!(x.keySet().contains(name))){
				System.out.println("Loading "+name+" into the map...");
				User currentUser=new User(name);
				x.put(name, currentUser);
			}
			
			User currentUser=x.get(name);
			User friendToAdd=new User(fileScanner.next());
			System.out.println("Adding a friend named "+friendToAdd+" to "+currentUser);
			currentUser.addFriends(friendToAdd);
			System.out.println(name+" now has "+ currentUser.friendNum()+" friends!");
		}//end while
		
		try {
			System.out.println("Enter a user name and all friends two links or less will be displayed.");
			String name=in.next();
			
			showFriends(name, 0);
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		for(Map.Entry<String, User> entry:x.entrySet()) {
			User user=entry.getValue();
			System.out.println(user +"'s friends are: ");
			System.out.println(user.friends);
		}
		
	}//end main
	
	static void showFriends(String name, int level) {
		System.out.println("----------------------------");
		if(level<=2) {
			User thisUser=x.get(name);
			
			for(int friendNum=1; friendNum<=thisUser.friendNum();friendNum++) {
				User currentFriend=thisUser.friendSelect(friendNum);
				System.out.println(thisUser+" is friends with "+currentFriend+"("+level+" links)");
				showFriends(currentFriend.getName(), level+1);
			}//end while
		}//end if
	}//end showFriends

}//end UserMain
