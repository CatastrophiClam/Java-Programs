package dataStructures;

public class GraphTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntGraph graph = new IntGraph(100);
		graph.addEdge(0,2,false);
		graph.addEdge(2,4,false);
		graph.addEdge(2,5,false);
		graph.addEdge(5,4,false);
		graph.addEdge(5,0,false);
		graph.addEdge(2,6,false);
		graph.addEdge(0,6,false);
		graph.addEdge(6,4,false);
		graph.addEdge(7,2,false);
		graph.addEdge(7,6,false);
		graph.addEdge(2,7,false);
		graph.findAllCycles();
	}

}
