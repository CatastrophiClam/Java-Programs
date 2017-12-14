package dataStructures;

public class MyQueue<E extends Comparable<E>> {
	Node<E> head = null;
	Node<E> tail = null;
	
	public MyQueue(){
		
	}
	
	public MyQueue(E element){
		head = new Node<E>(element);
		tail = head;
	}
	
	public void enqueue(E info){
		if (tail != null){
			Node<E> temp = new Node<E>(info);
			tail.setPreviousNode(temp);
			tail = temp;
		}else{
			head = new Node<E>(info);
			tail = head;
		}
	}
	
	public E dequeue(){
		Node<E> temp = head;
		if (head.hasPreviousNode()){
			head = head.getPreviousNode();
		}else{
			head = null;
			tail = null;
		}
		return temp.getInfo();
	}
}	
