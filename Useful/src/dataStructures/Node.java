package dataStructures;

public class Node<E>{
	private Node<E> previousNode = null;
	private E info;
	
	public Node(E info, Node<E> previousNode){
		this.info = info;
		this.previousNode = previousNode;
	}
	
	public Node(E info){
		this.info = info;
	}
	
	public E getInfo(){
		return info;
	}
	
	public Node<E> getPreviousNode(){
		return previousNode;
	}
	
	public void setPreviousNode(Node<E> node){
		previousNode = node;
	}
	
	public boolean hasPreviousNode(){
		return previousNode != null;
	}
}
