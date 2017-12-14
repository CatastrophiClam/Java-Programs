package dataStructures;

public class ProximityNode <E extends Comparable<E>>{
	private ProximityNode<E> parent;
	private E info;
	
	public ProximityNode(E info){
		this.info = info;
	}
	
	public ProximityNode(E info, ProximityNode<E> parent){
		this.info = info;
		this.parent = parent;
	}
	
	public E info(){
		return info;
	}
	
	public ProximityNode<E> parent(){
		return parent;
	}
	
	public void setParent(ProximityNode<E> parent){
		this.parent = parent;
	}
}
