package dynamicProgramming;

import java.util.ArrayList;

public class Graph {
	
	private ArrayList<ArrayList<Link>> edges = new ArrayList<ArrayList<Link>>();
	private int numVertices = 0;
	
	public Graph(){
		
	}
	
	public void addVerticies(int[][]vertices){
		for (int[] i : vertices){
			
		}
	}
	
	/**
	 * resizes edgeMatrix after adding new vertices
	 */
	public void resize(){
		//add more rows
		while (edges.size() < numVertices){
			edges.add(new ArrayList<Link>());
		}
		// add more columns
		for (ArrayList<Link> i:edges){
			while (i.size() < numVertices){
				i.add(new Link());
			}
		}
	}
	
	/**
	 * Class representing a link between two vertices of a graph
	 * hasEdge denotes if vertices are directly connected
	 * smallestWeight denotes smallest weight to travel between the two vertices
	 * @author Max
	 *
	 */
	class Link{
		private boolean hasEdge;
		private int weight;
		private ArrayList<Coord> path;
		
		public Link(){
			
		}
		
		public Link(boolean hasEdge, int smallestWeight){
			this.hasEdge = hasEdge;
			weight = smallestWeight;
		}
		
		public boolean edge(){
			return hasEdge;
		}
		
		public int smallestWeight(){
			return weight;
		}
		
		public ArrayList<Coord> getPath(){
			return path;
		}
	}
}
