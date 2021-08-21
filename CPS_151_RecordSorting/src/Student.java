/*
 * Student.java
 * Name: Devin Porter
 * Username: porterd3
 * Assignment: 7
 * 
 * This class simulates a Student, with data fields including a student ID number, a course number, a section number,
 * a semester, and a year. The class also implements the Comparable interface, as it uses an overridden compareTo
 * method in order to utilize the Collections.sort method in the main class. 
 * 
 * The constructor takes a parameter that is a single line of text, with "words" in the text separated by tabs.
 * It initializes a scanner to scan that line of text and assign each data field to one of those "words."
 * 
 * It also overrides the compareTo method so that when Collections.sort is called in main, the method sorts
 * the student objects in order from smallest to largest student ID.
 * 
 * Lastly, the class overrides the toString() method so that when called, it outputs the each of the data fields
 * in an efficient, clear manner. 
 */
import java.util.Scanner;
public class Student implements Comparable {
	private int studentID;
	private String courseNum;
	private int sectionNum;
 	private String semester;
 	private int year;
	 
	public Student(String info) {
		Scanner s= new Scanner(info);
	
		studentID=Integer.parseInt(s.next());
		courseNum=s.next();
		sectionNum=Integer.parseInt(s.next());
		semester=s.next();
		year=Integer.parseInt(s.next());
		s.close();
	}
	
	@Override
	public int compareTo(Object arg0) {
		Student s1=(Student) arg0;
		if (this.studentID==s1.studentID) {
			return 0;
		}
		else if (this.studentID<s1.studentID) {
			return -1;
		}
		else {
			return 1;
		}
	}//end compareTo
	
	public String toString() {
		String result="";
		result=result+"ID: "+studentID+" | Course: "+courseNum+" | Section: "+sectionNum+" | Semester: "+semester+" | Year: "+year+"\n";
		return result;
	}

}
