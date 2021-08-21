import java.util.*;

public class IntBuff {
	private int[] elements;
	private int current_size;
	
	//empty IntBuff with no elements
	IntBuff(){
		elements = new int[0];
		current_size=0;
	}//end IntBuff constructor
	
	//empty IntBuff with room for elements
	IntBuff(final int n) {
		elements=new int[n];
		current_size=0;
	}//end constructor
	
	//Copies one IntBuff to another IntBuff
	IntBuff(IntBuff buff){
		elements=Arrays.copyOf(buff.elements, buff.current_size);
		current_size=buff.current_size;
	}//end IntBuff copier
	
	//appends an integer to the end of an IntBuff
	boolean append(final int v) {
		if (current_size==elements.length) {
			IntBuff tempBuff=new IntBuff(elements.length+1);
			for(int i=0;i<current_size;i++) {
				tempBuff.elements[i]=this.elements[i];
			}
			elements=tempBuff.elements;
		}
		
		elements[current_size]=v;
		
		if(elements[current_size]!=v) {
			return false;
		}
		
		current_size++;
		return true;
	}//end append
	
	//inserts an integer into the IntBuff
	boolean insert(final int index, final int v) {
		if (current_size==elements.length) return false;
		
		int i=current_size-1;
		
		while(i>=index) {
			elements[i+1]=elements[i];
			i--;
		}
		
		current_size++;
		elements[index]=v;
		
		if (elements[index]==v) return true;
		else {return false;}
		
	}//end insert
	
	//deletes an integer in the IntBuff
	boolean delete(final int index) {
		int key = elements[index+1];
		
		for (int i=index; i<current_size;i++) {
			elements[i]=elements[i+1];
		}
		
		current_size--;
		
		if(elements[index]==key) {
			return true;
		}
		else {
			return false;
		}
	}//end delete
	
	void println() {
		System.out.println();
		for (int i=0; i<current_size; i++) {
			System.out.print(elements[i]+" ");
		}//end for
	}//end println
	
	// Performing a linear search for the value of v in the buffer.
	public boolean linearSearch(final int v)
	{
	  for (int i=0; i<elements.length; i++) {
		  if (elements[i]==v) {
			  System.out.println();
			  System.out.println("It has been found at index "+i);
			  return true;}
	  }
	  
	  return false;
	}//end linearSearch

	// Performing a binary search for the value of v in the buffer.
	public boolean binarySearch(final int v)
	{
	//make a new buffer so it can be sorted and still maintain the integrity of the original buffer.
	  System.out.println();
	  System.out.println("Begin binary search results: ");
	  IntBuff tempBuffer=new IntBuff(current_size);
	  tempBuffer.elements=Arrays.copyOf(elements, current_size);
	  tempBuffer.current_size=this.current_size;
	  tempBuffer.insertionSort();
	  tempBuffer.println();
	  System.out.println();
	  //set last, first, and middle indices.
	  int last=current_size-1;
	  int first=0;
	  int mid;
	  mid=(first+last)/2;
	 
	  //loop continuously, "cut" the array in half until the mid is equal to the value OR last is less than first.
	  while (last>=first) {
		  
		  if (v<tempBuffer.elements[mid]) {last=mid-1;}
		  else if(v>tempBuffer.elements[mid]) {first=mid+1;}
		  else {
				System.out.printf("The number exists in the array buffer, we just don't know where exactly... \nbut, if it were sorted in ascending order,"
						  + " it would be at position "+mid+". This returns ");
			  	return true;
			  	}//end else
		  mid=(first+last)/2; 
		  
	  }
	  return false;
	  
	}//end binarySearch

	// Sorting the elements (ascending order) in the buffer using insertion sort.
	public void insertionSort()
	{
		//loop through the buffer
	  for (int j=1;j<current_size;j++) {
		  int key=elements[j];
		  int i=j-1;
		  while (i>=0&&elements[i]>key) {
			  elements[i+1]=elements[i];
			  i=i-1;
		  }//end while
		  elements[i+1]=key;
	  }//end for
	}//end insertionSort
	
	public void quickSort() {
		internalQuickSorter(elements, 0, current_size-1);
	}
	private void internalQuickSorter(int[] a, int low, int high) {
		if(low<high){
			int q=partition(a, low, high);
			internalQuickSorter(a, low, q-1);
			internalQuickSorter(a, q+1, high);
		}
	}//end internalSorter
	
	private int partition(int[] a, int low, int high) {
		int pivot=a[high];
		int i=low-1;
		for (int j=low; j<=high-1; j++) {
			if (a[j]<=pivot) {
				i++;
				swap(i,j);
			}
		}
		swap(i+1,high);
		return (i+1);
	}//end partition
	private void swap(int index1, int index2) {
		int temp=elements[index1];
		elements[index1]=elements[index2];
		elements[index2]=temp;
	}
	
	public void mergeSort() {
		sort(elements, 0, current_size-1);
	}//end mergeSort
	
	private void sort(int[] a, int first, int last) {
		if (first<last) {
			int mid=(first+last)/2;
			sort(a, first, mid);
			sort(a, mid+1, last);
			merge(a, first, mid, last);
		}
	}//end sort
	
	private void merge(int[] a, int first, int mid, int last) {
		int[] tempArray = new int[(last-first)+1];
		int i=first;
		int k=mid+1;
		int j = 0;
		while (i<=mid&&k<=last) {
			if (a[i]<=a[k]) {
				tempArray[j]=a[i];
				j++; i++;
			}
			else {
				tempArray[j]=a[k];
				j++; k++;
			}
		}
		while(i<=mid) {
			tempArray[j]=a[i];
			j++; i++;
		}
		while(k<=last) {
			tempArray[j]=a[k];
			j++; k++;
		}
		
		for (int m=first;m<=last;m++) {
			elements[m]=tempArray[m-first];
		}
	}//end merge
}//end class IntBuff