package bigNums;
/*
 * Devin Porter, Paul Scheeler, Sydney Jenkins, Brandon Wong
 */
public class GraphTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph testGraph=new Graph(8);
		testGraph.add_edge(1,4, 8);
		testGraph.add_edge(1, 0, 2);
		testGraph.add_edge(0, 2, 5);
		testGraph.add_edge(2, 5, 7);
		testGraph.add_edge(5, 4, 18);
		testGraph.add_edge(5, 3, 10);
		testGraph.add_edge(4, 3, 4);
		testGraph.add_edge(0, 3, 30);
		testGraph.add_edge(2, 1, 15);
		
		int[] array=testGraph.DFS(4);
		for(int element:array) {
			System.out.println(element);
		}
	}

}
