
public class Node {
	String name;
	Node next;
	
	Node(){
		//initialize an empty Node, with no node following it.
		name=""; next=null;
	}//end empty Node constructor
	
	Node(final String str, final Node nextNode){
		//Initialize a Node with 
		name=str; next=nextNode;
	}//end populated Node constructor
	
	Node(final Node node){
		this.name=node.name;
		next=node.next;
	}//end Node copy constructor
	Node(final String str){
		name=str;
		next=null;
	}
	
	
	
}//end Node
