package sept29HmwkCh22;

public class Stack {
	Node currentNode = new Node(null);
	public Stack(){
		
	}
	
	public void push(String info){
		currentNode = new Node(info, currentNode);
	}
	
	public String pop(){
		String info = currentNode.getInfo();
		currentNode = currentNode.getPreviousNode();
		return info;
	}
	
	public String peek(){
		return currentNode.getInfo();
	}
}
