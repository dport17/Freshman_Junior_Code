package bigNums;
/*
 * Devin Porter, Paul Scheeler, Sydney Jenkins, Brandon Wong
 */
public class DirectedEdge {

	int start;			//start node
	int end;			//end node
	double weight;
	final int EMPTY = -1;
	
	DirectedEdge()
	{
		this.start = EMPTY;
		this.end = EMPTY;
		this.weight = EMPTY;
	}
	
	DirectedEdge(int start, int end, double weight)
	{
		this.start = start;
		this.end = end;
		this.weight = weight;
	}
	
}
