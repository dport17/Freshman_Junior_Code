
public class List {
	Node head;
	
	List(){
		head=new Node();
	}//end List
	
	List (final List list){
		head=new Node();
		Node iter1=head;
		Node iter2=list.head.next;
		for(; iter2!=null;iter2=iter2.next) {
				Node tmp=new Node(iter2.name);
				iter1.next=tmp;
				iter1=iter1.next;
		}
	}//end copy constructor
	
	void insert(final String name, final int index) {
		Node iter=head;
		for(int i=0;i<index;i++) {
			iter=iter.next;
		}//end for
		Node tmp=new Node(name, iter.next);
		iter.next=tmp;
		
	}//end insert
	
	String delete(final int index) {
		Node iter=head;
		for(int i=0;i<index;i++) {
			iter=iter.next;
		}//end for
		String deadNode=iter.next.name;
		iter.next=iter.next.next;
		return deadNode;
	}//end delete
	
	void println() {
		for(Node iter=head.next; iter!=null; iter=iter.next) {
			System.out.println(iter.name);
		}
	}
	
	boolean changeName(final String newName, final int index) {
		Node iter1=head;
		for(int i=0;i<index;i++) {
			if (iter1.next==null) {
				return false;
			}
			iter1=iter1.next;
		}//end for
		iter1.next.name=newName;
		return true;
	}//end changeName
	
	void copyOf(final List list) {
		Node iter=head;
		Node iter1=list.head.next;
		for(; iter1!=null;iter1=iter1.next) {
			Node temp=new Node(iter1.name);
			iter.next=temp;
			iter=iter.next;
		}
	}
	
	
}//end List class