package dynamicProgramming;

public class MultistageGraph {
	int[][]graph;
	int[][]edges;
	int[][]weights;
	
	public MultistageGraph(){
		
	}
	
	public void newGraph(int[][]graph){
		this.graph = graph;
	}
	
	public void newEdges(int[][]edges){
		this.edges = edges;
	}
	
	public void newWeights(int[][]weights){
		this.weights = weights;
	}
}
