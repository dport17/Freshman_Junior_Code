package bigNums;
/*
 * Devin Porter, Paul Scheeler, Sydney Jenkins, Brandon Wong
 */
public class Graph {
	
	DirectedEdge[] graph;
	int currentSize;
	final int EMPTY = -1;
	
	Graph(int size)
	{
		DirectedEdge[] graph = new DirectedEdge[size];
		for(int i = 0; i < size; i++)
			graph[i].start = EMPTY;
		
		int currentSize = 0;
	}
	
	// this linearly hashes elements into graph. returns true if successful
	boolean add_edge(int start, int end, int weight)
	{
		if(this.currentSize < this.graph.length)
		{
			int index = start % graph.length;
			for(; graph[index].start != EMPTY; index++)
			{
				// check whether you're still in the cluster. if not, return false
				if(graph[index].start != start)
					return false;
			}
			// if you get to this point, without returning false, it means you're in the cluster
			// so add your edge according to specification
			graph[index] = new DirectedEdge(start, end, weight);
			return true;
		}
		return false;
	}

	int[] DFS(int start)
	{
		int[] visited = new int[this.currentSize];
		final int NOT_VISITED = 0;
		for(int i = 0; i < currentSize; i++)
			visited[i] = NOT_VISITED;
		
		// start at the start location of the key
		int key = start;
		int index = key % this.graph.length;
		
		// use this to store the INDICES of vertices already visited in DFS (which you need to 
		// visit on your way back up)... the proverbial trail of crumbs
		int[] stack = new int[currentSize]; int top = 0;
		
		// this is your return variable, it stores all the vertices you've visited
		// each time you find a vertex which has no unvisited children, you add it to the list
		// and consult the stack
		// in the end, it will contain all vertices reachable from your start vertex
		int[] list = new int[currentSize]; int position = 0;
		
		// the DFS...
		// check whether the start key has children. if no children, add it to the list, return
		// if there are children, put its INDEX (derived from hashing function) in the stack, then go to its children
		// note, I'm using "children" (incorrectly) to refer to nodes to which the given node is connected.
		// these are children only in the special case of the binary tree
		// insert conditions...
		
		boolean notDone = true;
		
		while(notDone)
		{
			
			// DESCEND
			// descend the "tree" until you get to get to a vertex with no out going edges
			// or which has already been visited
			while(this.graph[index].end != EMPTY && notVisited(this.graph[index].end, visited) )
			{
				// add the vertex's index to the stack, so we can revisit it later
				top++;
				stack[top] = index;
				
				// go to the next index
				key = this.graph[key].end;
				index = key % currentSize;
				// this traverses the hash table, until it finds 
				for(; this.graph[index].start == key && !notVisited(this.graph[index].start, visited); index++);
			}
			if( notVisited(this.graph[key].end, visited) )
			{
				list[position] = key;
			}
			
			// ASCEND
			
			

			
			// we've returned to the start... done!
			// note, this only happens AFTER we've checked to see if start has any adjacent edges
			// in the graph[], which correspond to additional outgoing edges
			// this is checked above
			if(key == start)
				notDone = false;
		}

		return list;
		
	}
	
	// O(n) time complexity... sad
	boolean notVisited(int vertex, int[] visited)
	{
		// we want to know whether vertex has NOT been visited yet
		// if vertex is in the visited[] list, return false
		// otherwise, return true
		for(int i = 0; i<visited.length; i++)
		{
			if(visited[i] == vertex)
				return false;
		}
		
		// we didn't find it in the list... return true!
		return true;
	}
	

	
	int[] MinSpanTree()
	{
		// place holder variable
		int[] tree = new int[0];
		
		return tree;
	}
}
