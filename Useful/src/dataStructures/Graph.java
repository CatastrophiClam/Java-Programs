package dataStructures;
import java.util.ArrayList;

public class Graph <E extends Comparable<E>>{
	private ArrayList<E> vertexArray = new ArrayList<E>();
	private ArrayList<ArrayList<Integer>> edgeMatrix = new ArrayList<ArrayList<Integer>>();
	private ArrayList<ArrayList<Integer>> tips = new ArrayList<ArrayList<Integer>>(); //index of vertices
	//private ArrayList<ArrayList<Integer>> visited = new ArrayList<ArrayList<Integer>>();
	
	public Graph(){
		
	}
	
	public Graph(ArrayList<E> vertices){
		for (E i:vertices){
			if (!vertexArray.contains(i)){
				vertexArray.add(i);
			}
		}
		resize();
	}
	
	public Graph(E[] vertices){
		for (E i:vertices){
			if (!vertexArray.contains(i)){
				vertexArray.add(i);
			}
		}
		resize();
	}
	
	public Graph(ArrayList<E> vertices, ArrayList<E[]> edges){
		for (E i:vertices){
			if (!vertexArray.contains(i)){
				vertexArray.add(i);
			}
		}
		resize();
		for (E[] i:edges){
			edgeMatrix.get(vertexArray.indexOf(i[0])).set(vertexArray.indexOf(i[1]), 1);
			edgeMatrix.get(vertexArray.indexOf(i[1])).set(vertexArray.indexOf(i[0]), 1);
		}
	}
	
	public Graph(E[] vertices, E[][] edges){
		for (E i:vertices){
			if (!vertexArray.contains(i)){
				vertexArray.add(i);
			}
		}
		resize();
		for (E[] i:edges){
			edgeMatrix.get(vertexArray.indexOf(i[0])).set(vertexArray.indexOf(i[1]), 1);
			edgeMatrix.get(vertexArray.indexOf(i[1])).set(vertexArray.indexOf(i[0]), 1);
		}
	}
	
	public void addVertices(ArrayList<E> vertices){
		for (E i:vertices){
			if (!vertexArray.contains(i)){
				vertexArray.add(i);
			}
		}
		resize();
	}
	
	public void addVertex(E vertex){
		if (!vertexArray.contains(vertex)){
			vertexArray.add(vertex);
		}
		resize();
	}
	
	public void addEdges(ArrayList<E[]> edges){
		for (E[] i:edges){
			edgeMatrix.get(vertexArray.indexOf(i[0])).set(vertexArray.indexOf(i[1]), 1);
			edgeMatrix.get(vertexArray.indexOf(i[1])).set(vertexArray.indexOf(i[0]), 1);
		}
	}
	
	public void addEdges(E[][] edges){
		for (E[] i:edges){
			edgeMatrix.get(vertexArray.indexOf(i[0])).set(vertexArray.indexOf(i[1]), 1);
			edgeMatrix.get(vertexArray.indexOf(i[1])).set(vertexArray.indexOf(i[0]), 1);
		}
	}
	
	public void addEdge(E[] edge){
		edgeMatrix.get(vertexArray.indexOf(edge[0])).set(vertexArray.indexOf(edge[1]), 1);
		edgeMatrix.get(vertexArray.indexOf(edge[1])).set(vertexArray.indexOf(edge[0]), 1);
	}
	
	public void addOneEdges(ArrayList<E[]> edges){
		for (E[] i:edges){
			edgeMatrix.get(vertexArray.indexOf(i[0])).set(vertexArray.indexOf(i[1]), 1);
		}
	}
	
	public void addOneEdges(E[][] edges){
		for (E[] i:edges){
			edgeMatrix.get(vertexArray.indexOf(i[0])).set(vertexArray.indexOf(i[1]), 1);
		}
	}
	
	public void addOneEdge(E[] edge){
		edgeMatrix.get(vertexArray.indexOf(edge[0])).set(vertexArray.indexOf(edge[1]), 1);
	}
	
	/**
	 * 
	 * @param startVertex
	 * @param endVertex
	 * @returns the shortest path from startvertex to endvertex - NOTE: PATH INCLUDES STARTVERTEX AND ENDVERTEX
	 */
	public ArrayList<E> findShortestPath(E startVertex, E endVertex){
		ArrayList<Boolean> visited = new ArrayList<Boolean>();  // whether we visited a vertex or not
		for (int i = 0; i < vertexArray.size(); i++){
			visited.add(false);
		}
		visited.set(vertexArray.indexOf(startVertex), true); // mark start as visited
		ProximityTree<E> tree = new ProximityTree<E>(startVertex);  // tree for storing all paths
		MyQueue<E> queue = new MyQueue<E>();  // queue for going through the vertices
		queue.enqueue(startVertex);
		E current;
		
		// The next part takes an element from the queue and looks at all its neighbours. If one of them == endVertex, we're done.
		// If not, add them to queue
		
		// while we haven't visited all the vertices
		while (visited.contains(false)){
			current = queue.dequeue();
			//for all of current's neighbours:
			for (E i: findAllNeighbours(current)){
				// if they're unvisited
				if (!visited.get(vertexArray.indexOf(i))){
					visited.set(vertexArray.indexOf(i), true); // mark i as visited
					tree.add(i, current); // add vertex to tree
					// if we have reached endVertex, return the path
					if (i.equals(endVertex))
						return tree.findPath(endVertex);
					//else, add to queue
					queue.enqueue(i);
				}
			}
		}
		return null;
	}
	
	public ArrayList<E> findAllNeighbours(E vertex){
		ArrayList<E> neighbours = new ArrayList<E>(); // array we return
		ArrayList<Integer> vertices = edgeMatrix.get(vertexArray.indexOf(vertex)); // slice of Edgematrix that contains the 1's and 0's denoting neighbours for vertex
		for (int i = 0; i < vertices.size(); i++){
			if (vertices.get(i) == 1){
				neighbours.add(vertexArray.get(i));
			}
		}
		return neighbours;
	}
	
	/**
	 * resizes edgeMatrix after adding new vertices
	 */
	public void resize(){
		//add more rows
		while (edgeMatrix.size() < vertexArray.size()){
			edgeMatrix.add(new ArrayList<Integer>());
		}
		// add more columns
		for (ArrayList<Integer> i:edgeMatrix){
			while (i.size() < vertexArray.size()){
				i.add(0);
			}
		}
	}
	
	/**
	 * works with indexes of vertices
	 * @returns true if the graph contains at least one cycle (node has a path back to itself)
	 */
	public boolean hasCycles(){
		ArrayList<Integer> neighbours = new ArrayList<Integer>();
		ArrayList<Integer> temp = new ArrayList<Integer>();
		ArrayList<Integer> pastArray = new ArrayList<Integer>();
		boolean change;
		boolean verifier;
		//for every vertex
		for (int i = 0; i < vertexArray.size(); i++){
			neighbours.clear();
			tips.clear();
			//visited.clear();
			// find all neighbours of that vertex
			neighbours = getAllNeighbours(i);
			// if that vertex can have a cycle
			if (neighbours.size()>1){
				//check if it has a cycle
				for (int j = 0; i < neighbours.size(); i++){
					// find neighbours of neighbours
					for (int k = 0; k < neighbours.size(); k++){
						temp = getAllNeighbours(neighbours.get(k));
						tips.add(temp);
						tips.get(k).add(neighbours.get(i));
					}
					// at this point, for each neighbour at neighbours.get(k), there should be an arraylist at tips.get(k) with itself and all its neighbours
					change = true;
					// we want tips.get(k) to contain all the reachable vertices from neighbours.get(k)
					// while we are still finding more vertices, check for a connection, then find more
					// a connection is when tips.get(x) and tips.get(y) have a common vertex - this means there is a cycle and we are done
					while (change){
						// check every pair of neighbours' tips for connections
						for (int l = 0; l < tips.size(); l++){
							for (int m = 0; m < tips.size(); m++){
								if (hasCommon(tips.get(l), tips.get(m))){
									return true;
								}
							}
						}
						// find more tips
						change = false; // nothing has changed unless we find something that has changed
						// for every set of tips,
						for (ArrayList<Integer> l: tips){
							//find all neighbours and add to set
							pastArray = l;
							for (int m:l){
								addAll(l, getAllNeighbours(m));
							}
							// if something changed, update change
							if (!isSame(pastArray, l)){
								change = true;
							}
						}
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @param index
	 * @returns indexes of all neighbours of vertex at index
	 */
	public ArrayList<Integer> getAllNeighbours(int index){
		ArrayList<Integer> neighbours = new ArrayList<Integer>();
		for (int i = 1; i < edgeMatrix.get(index).size(); i++){
			if (edgeMatrix.get(index).get(i) == 1){
				neighbours.add(i);
			}
		}
		return neighbours;
	}
	
	public boolean hasCommon(ArrayList<Integer> array1, ArrayList<Integer> array2){
		for (int i:array1){
			for (int j:array2){
				if (i==j){
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @param array
	 * @param added
	 * Adds all elements in added to array
	 */
	public void addAllE(ArrayList<E> array, ArrayList<E> added){
		for (E i: added){
			if (!array.contains(i)){
				array.add(i);
			}
		}
	}
	
	public void addAll(ArrayList<Integer> array, ArrayList<Integer> added){
		for (Integer i: added){
			if (!array.contains(i)){
				array.add(i);
			}
		}
	}
	
	/**
	 * 
	 * @param array1
	 * @param array2
	 * @returns true if array2 contains all elements in array1
	 */
	public boolean isSame(ArrayList<Integer> array1, ArrayList<Integer> array2){
		if (array1.size()!= array2.size())
			return false;
		for (int i: array1){
			// for every element in array1, if array2 doesn't contain it, the arrays are different
			if (!array2.contains(i)){
				return false;
			}
		}
		return true;
	}
	
	/**
	 * works with indexes of vertices
	 * @returns true if the graph contains at least one cycle (node has a path back to itself)
	 */
	public ArrayList<ArrayList<E>> allCycles(){
		ArrayList<Integer> neighbours = new ArrayList<Integer>();
		ArrayList<Integer> temp = new ArrayList<Integer>();
		ArrayList<Integer> pastArray = new ArrayList<Integer>();
		ArrayList<ArrayList<E>> paths = new ArrayList<ArrayList<E>>();
		ArrayList<E> tempPath = new ArrayList<E>();
		boolean change;
		boolean verifier;
		//for every vertex
		for (int i = 0; i < vertexArray.size(); i++){
			neighbours.clear();
			tips.clear();
			//visited.clear();
			// find all neighbours of that vertex
			neighbours = getAllNeighbours(i);
			// if that vertex can have a cycle
			if (neighbours.size()>1){
				//check if it has a cycle
				for (int j = 0; i < neighbours.size(); i++){
					// find neighbours of neighbours
					for (int k = 0; k < neighbours.size(); k++){
						temp = getAllNeighbours(neighbours.get(k));
						tips.add(temp);
						tips.get(k).add(neighbours.get(i));
					}
					// at this point, for each neighbour at neighbours.get(k), there should be an arraylist at tips.get(k) with itself and all its neighbours
					change = true;
					// we want tips.get(k) to contain all the reachable vertices from neighbours.get(k)
					// while we are still finding more vertices, check for a connection, then find more
					// a connection is when tips.get(x) and tips.get(y) have a common vertex - this means there is a cycle and we are done
					while (change){
						// check every pair of neighbours' tips for connections
						for (int l = 0; l < tips.size(); l++){
							for (int m = 0; m < tips.size(); m++){
								// if there is a connection, find paths and add them to paths
								if (hasCommon(tips.get(l), tips.get(m))){
									// arrays l and m have a common vertex
									for (int n = 0; n < tips.get(l).size(); n++){
										// find common vertex
										if (tips.get(m).contains(tips.get(l).get(n))){
											tempPath = findShortestPath(vertexArray.get(neighbours.get(l)), vertexArray.get(tips.get(l).get(n)));
											addAllE(tempPath, findShortestPath(vertexArray.get(tips.get(l).get(n)), vertexArray.get(neighbours.get(m))));
											paths.add(tempPath);
										}
									}
								}
							}
						}
						// find more tips
						change = false; // nothing has changed unless we find something that has changed
						// for every set of tips,
						for (ArrayList<Integer> l: tips){
							//find all neighbours and add to set
							pastArray = l;
							for (int m:l){
								addAll(l, getAllNeighbours(m));
							}
							// if something changed, update change
							if (!isSame(pastArray, l)){
								change = true;
							}
						}
					}
				}
			}
		}
		return paths;
	}

}
