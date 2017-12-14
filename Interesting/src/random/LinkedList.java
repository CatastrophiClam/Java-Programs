package random;

public class LinkedList<E>{
	private Node root;
	private Node head;
	private boolean hasRoot = false;
	private int length;
	
	public LinkedList(){
		
	}
	
	/**
	 * HEAD HAS INDEX 0
	 * @param regex
	 */
	public void add(E regex){
		if (hasRoot){
			head = new Node(regex, head);
		}else{
			root = new Node(regex);
		}
		length++;
	}
	
	/**
	 * add regex to spot at index
	 * pushes node at index to index+1
	 * @param regex
	 * @param 
	 */
	public void add(E regex, int index){
		if (index != 0){
			Node fatherNode = getNode(index-1);
			Node regexNode = new Node(regex, fatherNode.getPreviousNode());
			fatherNode.setPreviousNode(regexNode);
			length++;
		}else{
			add(regex);
		}
		
	}
	
	/**
	 * HEAD HAS INDEX 0
	 * @param index
	 * @return
	 */
	public E get(int index){
		Node nowNode = head;
		for(int i = 1; i < index; i++){
			nowNode = nowNode.getPreviousNode();
		}
		return nowNode.getInfo();
	}
	
	public Node getNode(int index){
		Node nowNode = head;
		for(int i = 1; i < index; i++){
			nowNode = nowNode.getPreviousNode();
		}
		return nowNode;
	}
	
	public int getLength(){
		return length;
	}
	
	class Node{
		private Node previousNode = null;
		private E info;
		
		public Node(E info, Node previousNode){
			this.info = info;
			this.previousNode = previousNode;
		}
		
		public Node(E info){
			this.info = info;
		}
		
		public E getInfo(){
			return info;
		}
		
		public Node getPreviousNode(){
			return previousNode;
		}
		
		public void setPreviousNode(Node n){
			previousNode = n;
		}
	}
}
