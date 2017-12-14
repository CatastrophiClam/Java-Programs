package dataStructures;
import java.util.*;

public class IntGraph {
	final int MAX_VERTICIES = 1000;
	final int MAX_DEGREE = 100; //max number of edges from each vertex
	int[][] edges = new int[MAX_VERTICIES][MAX_DEGREE]; //records the edges from each vertex
	int[] numChildren = new int[MAX_VERTICIES]; //number of children of each vertex
	int[] parents = new int[MAX_VERTICIES]; //keeps track of parent of each vertex
	//TYPE[] key = new TYPE[MAX_VERTICIES]; - if each vertex has info
	int numVerticies = 0;
	int numEdges = 0;
	
	ArrayList<ArrayList<Integer>> cycles = new ArrayList<ArrayList<Integer>>();
	
	public IntGraph(int numVerticies){
		this.numVerticies = numVerticies;
	}
	
	public void addEdge(int x, int y, boolean directed){
		if (numChildren[x]<MAX_DEGREE){
			edges[x][numChildren[x]]=y;
			numChildren[x]++;
			if (!directed){
				edges[y][numChildren[y]]=x;
				numChildren[y]++;
			}
		}else{
			System.out.println("Too many edges!");
		}
	}
	
	boolean visited[] = new boolean[MAX_VERTICIES]; //have we visited this vertex before?
	boolean processed[] = new boolean[MAX_VERTICIES]; //have we visited all the offspring of this vertex?
	
	public ArrayList<ArrayList<Integer>> findAllCycles(){
		for (int i = 0; i < numVerticies; i++){
			if (!visited[i]){
				parents[i] = -1;
				find(i);
			}
		}
		return cycles;
	}
	
	public void find(int start){
		visited[start] = true;
		for (int i = 0; i < numChildren[start];i++){
			if (!visited[edges[start][i]]){
				parents[edges[start][i]] = start;
				find(edges[start][i]);
			}else{
				if (!processed[edges[start][i]]){
					process(start,edges[start][i]);
				}
			}
		}
		processed[start]=true;
	}
	
	public void process(int x, int y){
		if (parents[y]!=x){
			recordPath(y,x);
		}
	}
	
	public void recordPath(int start, int end){
		cycles.add(new ArrayList<Integer>());
		int index = cycles.size()-1;
		while (end != start){
			cycles.get(index).add(0,end);
			end = parents[end];
		}
		cycles.get(index).add(0,start);
		System.out.println(cycles.get(index));
	}
}






