package dataStructures;

public class HuffmanNode{
	private HuffmanNode left = null;
	private HuffmanNode right = null;
	private String info;
	private int weight;

	public HuffmanNode(String info) {
		this.info = info;
		weight ++;
	}
	
	public HuffmanNode(String info, int weight){
		this.info = info;
		this.weight = weight;
	}
	
	public HuffmanNode(int weight){
		this.weight = weight;
	}
	
	public void addLeft(HuffmanNode node){
		left = node;
	}
	
	public void addRight(HuffmanNode node){
		right = node;
	}
	
	public HuffmanNode getLeft(){
		return left;
	}
	
	public HuffmanNode getRight(){
		return right;
	}
	
	public void addWeight(){
		weight ++;
	}
	
	public void addWeight(int i){
		weight += i;
	}
	
	public int getWeight(){
		return weight;
	}

}
