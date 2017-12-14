package sept29HmwkCh22;

public class Node {
	private Node previousNode = null;
	private String info;
	
	public Node(String info, Node previousNode){
		this.info = info;
		this.previousNode = previousNode;
	}
	
	public Node(String info){
		this.info = info;
	}
	
	public String getInfo(){
		return info;
	}
	
	public Node getPreviousNode(){
		return previousNode;
	}
}
