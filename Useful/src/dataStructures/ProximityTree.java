package dataStructures;
import java.util.HashMap;
import java.util.ArrayList;

/**
 * 
 * @author Max
 *
 * This tree models a certain aspect of a graph.
 * The root is a vertex on the graph. 
 * The tree provides the shortest path to each other vertex through edges
 */
public class ProximityTree <E extends Comparable<E>>{
	
	ProximityNode<E> root = null;
	HashMap<E, ProximityNode<E>> nodes = new HashMap<E, ProximityNode<E>>(); // map with nodes as value and their info as keys
	int numNodes = 0;
	
	public ProximityTree(){
		nodes.put(null, null);
	}
	
	public ProximityTree(E info){
		root = new ProximityNode<E>(info, null);
		nodes.put(info, root);
		numNodes++;
	}
	
	public ProximityTree(E[] info, E[] parent){
		root = new ProximityNode<E>(info[0], null);
		nodes.put(info[0], root);
		numNodes++;
		for (int i = 1; i < info.length; i++){
			nodes.put(info[i], new ProximityNode<E>(info[i], nodes.get(parent)));
			numNodes++;
		}
	}
	
	public void add(E info, E parent){
		if (parent == null){
			root = new ProximityNode<E>(info, null);
			nodes.put(info, root);
		}else{
			nodes.put(info, new ProximityNode<E>(info, nodes.get(parent)));
		}
		numNodes++;
	}
	
	/**
	 * 
	 * @param info
	 * @returns the shortest path from root to info - NOTE: RETURNS ROOT AND INFO
	 * 
	 */
	public ArrayList<E> findPath(E info){
		ArrayList<E> path = new ArrayList<E>();
		path.add(info);
		ProximityNode<E> current = nodes.get(info);
		//while we haven't gotten to the root yet
		while (!current.info().equals(root.info())){
			//go to parent
			current = current.parent();
			path.add(0, current.info());
		}
		return path;
	}
	
	public int numNodes(){
		return numNodes;
	}
	
	public boolean contains(E info){
		return nodes.containsKey(info);
	}
	
	public int size(){
		return nodes.size();
	}
}
