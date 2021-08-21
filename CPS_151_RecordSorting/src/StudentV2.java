import java.util.*;
public class StudentV2 implements Comparable{
	 private int studentID;
	 private String courseNum;
	 private int sectionNum;
	 private String semester;
	 private int year;
	 
	public StudentV2 (String info) {
		Scanner s= new Scanner(info);
	
		studentID=Integer.parseInt(s.next());
		courseNum=s.next();
		sectionNum=Integer.parseInt(s.next());
		semester=s.next();
		year=Integer.parseInt(s.next());
		s.close();
	}
	
	public int getID() {
		return studentID;
	}
	@Override
	public int compareTo(Object arg0) {
		StudentV2 s1=(StudentV2) arg0;
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
		result=result+"ID: "+studentID+" | Course: "+courseNum+" | Section: "+sectionNum+" | Semester: "+semester+" | Year: "+year;
		return result;
	}
}
