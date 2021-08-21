import java.io.*;
import java.util.*;
public class testMain {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int x=0;
		Scanner fileScan=new Scanner(new File("students.txt"));
		ArrayList<String> testList=new ArrayList<String>();
		while (fileScan.hasNextLine()) {
			testList.add(fileScan.nextLine());
			x++;
		}
		System.out.println(x);
		
	}//end main

}
