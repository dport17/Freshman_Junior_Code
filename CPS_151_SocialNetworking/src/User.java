/*
 * User.java  
 * 
 * Name:Devin Porter
 * Username: porterd3
 * Assignment: 8
 * 
 * This program represents a 'User' who has friends on a social media platform. It provides a constructor to initialize a HashSet, and give the user 
 * a name. It also provides a variety of methods. The method getName() returns the string user_name that corresponds with the User. The method 
 * addFriends(User x) adds a different User object to the friends HashSet for each user. The method friendNum() returns the number of friends in the 
 * HashSet. The method friendSelect(int index) permits a User at an index in the friends HashSet to be accessed. 
 * 
 * Afterwards, the hashCode(), equals(Object obj), and toString() methods are overridden. 
 * 
 * Bug report: The nature of the friends HashSet causes some issues with repeating friends of friends multiple times due to friends in common.
 * 
 */ 
import java.util.*;
public class User {
	
	String user_name;
	Set<User> friends;
	
	public User(String name) {
		user_name=name;
		friends=new HashSet<User>();
	}//end constructor
	
	public String getName() {
		return user_name;
	}//end getName
	
	public void addFriends(User x) {
		friends.add(x);
	}//end addFriends
	
	public int friendNum() {
		return friends.size();
	}//end friendNum
	
	public User friendSelect(int index) {
		Iterator<User> iter= friends.iterator();
		int i=0;
		User thatUser=iter.next();
		while(i<index-1) {
			thatUser=iter.next();
			i++;
		}//end while loop
		
		return thatUser;
		
	}//end friendSelect
	
	@Override
	public int hashCode() {
		return user_name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (user_name == null) {
			if (other.user_name != null)
				return false;
		} else if (!user_name.equals(other.user_name))
			return false;
		return true;
	}

	public String toString() {
		return user_name;
	}
	
}//end User
