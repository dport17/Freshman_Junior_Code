import java.util.*;
public class IntBuffMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//1.
		IntBuff buffer=new IntBuff(5);
		buffer.append(6);
		buffer.append(5);
		buffer.append(7);
		buffer.append(10);
		buffer.append(0);
		buffer.append(1);
		buffer.append(-1);
		buffer.append(3);
		
		//5. Put here so I am not mergeSorting an already sorted buffer.
		IntBuff buffer2=new IntBuff(buffer);

		//2.
		buffer.println();
		//3.
		buffer.quickSort();
		//4.
		buffer.println();
		
		//5. See above.
		buffer2.println();
		//6.
		buffer2.mergeSort();
		
		//7.
		buffer2.println();
		
	}//end main

}
