package bigNums;

/*
 * Devin Porter, Paul Scheeler, Sydney Jenkins, Brandon Wong
 */

public class MinHeap {
	
	DirectedEdge[] heap;
	int currentSize;
	int maxSize;
	
	//create an empty heap of size max
	MinHeap(int max)
	{
		currentSize=0;
		maxSize=max;
		heap = new DirectedEdge[maxSize];
	}
	
	void enqueue(DirectedEdge edge)
	{
		//add the edge to the heap
		this.heap[this.currentSize]=edge;
		this.currentSize++;
		
		//now sort the heap (heapify)
		
		//if you're smaller than your parent, swap places
		int i = currentSize-1;
		while(i>0)
		{
			double current = heap[i].weight;
			double parent = heap[(i-1)/2].weight;
			if(current < parent)
			{
				DirectedEdge temp = heap[i];
				heap[i] = heap[(i-1)/2];
				heap[(i-1)/2] = temp;
				
				i = (i-1/2);
			}
			else
				i=0;
		}

	}
	

	
	DirectedEdge dequeue()
	{
		//get the smallest element and delete it
		DirectedEdge returnVar = this.heap[0];		
		this.heap[0]=this.heap[currentSize-1];
		this.currentSize--;
		
		int i = 0;
		while(2*i+1 < currentSize )
		{
			double current = heap[i].weight;
			double left = heap[2*i+1].weight;
			double right = heap[2*i+2].weight;
			
			//if you're bigger than your children, swap places with the smallest of them
			if(current > left || current > right)
			{
				if(left<right)
				{
					DirectedEdge temp = heap[i];
					heap[i]=heap[2*i+1];
					heap[2*i+1]=temp;
					i = 2*i + 1;
				}
				else
				{
					DirectedEdge temp = heap[i];
					heap[i]=heap[2*i+2];
					heap[2*i+2]=temp;
					i = 2*i + 2;
				}
			} // end main if
			else
				i = currentSize; //this effectively ends the loop	
		}

		//return the min value
		return returnVar;
	}

}
