package dataStructures;

public class TreeNode <E extends Comparable<E>> {
	private E info;
	private TreeNode<E> left = null;
	private TreeNode<E> right = null;
	
	public TreeNode(E info){
		this.info = info;
	}
	
	public E getInfo(){
		return info;
	}
	
	public void addLeft(TreeNode<E> node){
		if (left==null){
			left = node;
		}
	}
	
	public void addRight(TreeNode<E> node){
		if (right==null){
			right = node;
		}
	}
	
	public TreeNode<E> getLeft(){
		return left;
	}
	
	public TreeNode<E> getRight(){
		return right;
	}
	
	public boolean hasLeft(){
		return left!=null;
	}
	
	public boolean hasRight(){
		return right!=null;
	}
}
