package algorithms;


/**
 * 
 * @author Max
 * Prim's algorithm is a greedy algorithm that creates the minimum spanning tree of a graph - the 
 * combined edge weights of this tree is the smallest possible
 */
public class PrimTest {
	
	final static int MAXVERTICES = 10000;
	final static int MAXDEGREE = 1000;
	//Graph
	static int[][][] edges = new int[MAXVERTICES][MAXDEGREE][2]; //0 reps destination, 1 reps weight
	static int[] degrees = new int[MAXVERTICES];
	static int [] distances = new int[MAXVERTICES+1]; //smallest distance from node i to ANY NODE IN THE TREE
	static int numVertices = 0;
	static int numEdges = 0;
	static boolean inTree[] = new boolean[MAXVERTICES]; //is node i part of the tree?
	static int[]parents = new int[MAXVERTICES+1];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//INIT GRAPH, NUMVERTICES, NUMEDGES
		
		//init other stuff
		for (int i = 0; i < numVertices; i++){
			distances[i] = 1000000000;
			parents[i] = -1;
		}
		
		int v,w,weight,dist;
		v = 1;
		
		while (!inTree[v]){
			inTree[v] = true;
			
			//update all the shortest distances of the not-in-tree nodes that current node touches
			for (int i = 0; i < degrees[v]; i++){
				w = edges[v][i][0];
				weight = edges[v][i][1];
				if (!inTree[w]&&(weight<distances[w])){
					distances[w] = weight;
					parents[w] = v;
				}
			}
			
			//find node with the shortest distance to any vertex in the tree, add it to the tree
			v = 1;
			dist = 1000000000;
			for (int i = 2; i < numVertices; i++){
				if (!inTree[i]&&(distances[i]<dist)){
					dist = distances[i];
					v = i;
				}
			}
		}
	}

	
	
	
}
