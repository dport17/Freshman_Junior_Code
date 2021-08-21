
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1.
		List list1=new List();
		//2.
		list1.insert("Bob",0);
		list1.insert("Jane",0);
		list1.insert("Ann", 0);
		list1.insert("Tom",0);
		//3.
		list1.println();
		
		//4.
		List list2=new List(list1);
		String input=list2.head.next.name;
		//5.
		list2.changeName("Tim", 0);
		System.out.println();
		list2.println();
		System.out.println();
		list1.println();
		
		//6.
		List list3=new List();
		list3.copyOf(list2);
		Node iterator=new Node();
		iterator=list3.head;
		int lastIndex=-1;
		while(iterator.next!=null) {
			iterator=iterator.next;
			lastIndex++;
		}
		list3.changeName("Tim", lastIndex);
		
		System.out.println();
		System.out.println("List 3:");
		list3.println();
		
		System.out.println();
		System.out.println("List 2:");
		list2.println();
	}//end main

}//end main class
