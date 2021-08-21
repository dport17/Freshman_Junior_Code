import java.util.*;
public class IntBuffMain2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntBuff buffer2=new IntBuff(10);
		buffer2.append(10);
		buffer2.append(9);
		buffer2.append(8);
		buffer2.append(4);
		buffer2.append(12);
		buffer2.append(200);
		buffer2.println();
		
		buffer2.mergeSort();
		buffer2.println();
	}

}
