package dataStructures;

public class Stack <E>{
	Node<E> currentNode = new Node<E>(null);
	public Stack(){
		
	}
	
	public void push(E info){
		currentNode = new Node<E>(info, currentNode);
	}
	
	public E pop(){
		E info = currentNode.getInfo();
		currentNode = currentNode.getPreviousNode();
		return info;
	}
	
	public E peek(){
		return currentNode.getInfo();
	}
	
	public boolean isEmpty(){
		return currentNode.getInfo().equals(null);
	}
}
