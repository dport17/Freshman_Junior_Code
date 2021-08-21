import java.io.*;
import java.util.*;
/*
 * studentMain.java
 * Name: Devin Porter
 * Username: porterd3
 * Assignment: 7
 * 
 * This program creates an array of Student objects by reading information about each object from a file and 
 * passing that info to the Student constructor continuously until the array list has a student object for each
 * different line of text in the file. 
 * 
 * Once the array has been populated with Student objects, the program outputs the details of each object. 
 * Next, the program sorts those objects based on student ID.
 * 
 * Lastly, the program writes the details of the sorted Student objects to a new file. 
 */
public class studentMain {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ArrayList<Student> studentRecords=new ArrayList<Student>();
		
		File inputFile=new File("courses.txt");
		Scanner fileScanner=new Scanner(inputFile);
		
		while(fileScanner.hasNextLine()) {
			studentRecords.add(new Student(fileScanner.nextLine()));
		}//end while loop
		
		Collections.sort(studentRecords);
		
		for(Student element:studentRecords) {
			System.out.println(element);
		}
		
		PrintWriter writer=new PrintWriter("students.txt");
		for (int i=0; i<studentRecords.size();i++) {
			writer.println(studentRecords.get(i));
		}
		System.out.println(studentRecords.size());
	}

}
