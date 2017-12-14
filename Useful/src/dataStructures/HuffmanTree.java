package dataStructures;

public class HuffmanTree {
	HuffmanNode root;
	
	public HuffmanTree(){
		
	}
	
	public HuffmanTree(HuffmanNode node){
		root = node;
	}
	
	public HuffmanTree(HuffmanTree t1, HuffmanTree t2){
		root = new HuffmanNode(t1.root.getWeight()+t2.root.getWeight());
	}
	
	public HuffmanNode getRoot(){
		return root;
	}
	
	
}
