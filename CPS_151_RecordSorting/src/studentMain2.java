import java.io.*;
import java.util.*;

public class studentMain2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ArrayList<StudentV2> studentRecords=new ArrayList<StudentV2>();
		Scanner in=new Scanner(System.in);
		
		File inputFile=new File("courses.txt");
		Scanner fileScanner=new Scanner(inputFile);
		
		
		while(fileScanner.hasNextLine()) {
			
			studentRecords.add(new StudentV2(fileScanner.nextLine()));
		}//end while loop
		Collections.sort(studentRecords);
		
		for(StudentV2 element:studentRecords) {
			System.out.println(element);
		}
		
		PrintWriter writer=new PrintWriter("students.txt");
		for (StudentV2 element:studentRecords) {
			writer.println(element);
		}
		System.out.println(studentRecords.size());
	}//end main

}//end studentMain2