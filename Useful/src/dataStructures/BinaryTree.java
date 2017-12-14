package dataStructures;
import java.util.*;
import java.lang.Math;

public class BinaryTree<E extends Comparable<E>> {
	TreeNode<E> root = null;
	String asString = "No traversal applied";
	int height = 0;
	int numNodes = 0;
	int numLeaves = 0;
	ArrayList<E> valueArray = new ArrayList<E>();
	int index = -1;
	
	public BinaryTree(){
		
	}
	
	public BinaryTree(E value){
		this.root = new TreeNode<E>(value);
	}
	
	/**
	 * 
	 * @param value
	 * @return see if value is in tree
	 */
	public boolean find(E value){
		TreeNode<E> current = root;
		while (current!= null){
			if (value.compareTo(current.getInfo()) < 0){
				current = current.getLeft();
			}else if (value.compareTo(current.getInfo()) > 0){
				current = current.getRight();
			}else{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Adds value to tree
	 * @param value
	 * @return true if value added successfully, false if not
	 */
	public boolean add (E value) {
		if (root==null){
			root = new TreeNode<E>(value);
			height = 1;
			numNodes++;
			return true;
		}else{
			int tempHeight = 1;
			TreeNode<E> current = root;
			TreeNode<E> parent = current;
			while (current!=null){
				tempHeight++;
				if (value.compareTo(current.getInfo()) < 0){
					parent = current;
					current = current.getLeft();
				}else if(value.compareTo(current.getInfo()) > 0){
					parent = current;
					current = current.getRight();
				}else{
					return false;
				}
			}
			if (value.compareTo(parent.getInfo()) > 0){
				parent.addRight(new TreeNode<E>(value));
			}else{
				parent.addLeft(new TreeNode<E>(value));
			}
			if (tempHeight > height)
				height = tempHeight;
			numNodes++;
			return true;
		}
	}
	
	/**
	 * turns tree into sorted string
	 */
	public String toString(){
		return asString;
	}
	
	public void inOrder(){
		asString = "";
		if (root!=null){
			inOrder(root);
		}
	}
	
	public void inOrder(TreeNode<E> node){
		if (node.hasLeft()){
			inOrder(node.getLeft());
		}
		asString += (node.getInfo() + " ");
		if (node.hasRight()){
			inOrder(node.getRight());
		}
	}
	
	/**
	 * organizes string representing Tree
	 */
	public void breadthFirstTraversal(){
		asString = "";
		if (root!=null){
			ArrayList<TreeNode> array = new ArrayList<TreeNode>();
			array.add(root);
			breadthFirstTraversal(array);
		}
	}
	
	/**
	 * One iteration adds one level of tree to asString
	 * @param array
	 */
	public void breadthFirstTraversal(ArrayList<TreeNode> array){
		ArrayList<TreeNode> nextArray = new ArrayList<TreeNode>();
		for (TreeNode i:array){
			asString += (i.getInfo()+" ");
			if (i.hasLeft())
				nextArray.add(i.getLeft());
			if (i.hasRight())
				nextArray.add(i.getRight());
		}
		asString += "\n";
		// If there are still more nodes, call itself
		if (nextArray.size()>0){
			breadthFirstTraversal(nextArray);
		}
	}
	
	public void toArrayList(){
		valueArray.clear();
		if (root!=null){
			toArrayList(root);
		}
	}
	
	public void toArrayList(TreeNode node){
		if (node.hasLeft()){
			toArrayList(node.getLeft());
		}
		valueArray.add((E)(node.getInfo()));
		if (node.hasRight()){
			toArrayList(node.getRight());
		}
	}
	
	public void rebalance(){
		toArrayList();
		root = null;
		addAtHalf(valueArray);
	}
	
	public void refreshArrayList(){
		toArrayList();
	}
	
	public boolean hasNext(){
		return index < valueArray.size()-1;
	}
	
	public E next(){
		if (index < valueArray.size()-1){
			return valueArray.get(++index);
		}else{
			return null;
		}
	}
	
	public boolean hasPrevious(){
		return index > 0;
	}
	
	public E previous(){
		if (index > 0){
			return valueArray.get(--index);
		}else{
			return null;
		}
	}
	
	public void addAtHalf(ArrayList<E> array){
		if (array.size() == 1){
			add(array.get(0));
		}else if (array.size() == 2){
			add(array.get(0));
			add(array.get(1));
		}else{
			add(array.get(array.size()/2));
			ArrayList<E> beginHalfList = new ArrayList<E>();
			for (int i = 0; i < array.size()/2; i++){
				beginHalfList.add(array.get(i));
			}
			addAtHalf(beginHalfList);
			ArrayList<E> endHalfList = new ArrayList<E>();
			for (int i = array.size()/2+1; i < array.size(); i++){
				endHalfList.add(array.get(i));
			}
			addAtHalf(endHalfList);
		}
	}
	
	public int numLeaves(){
		numLeaves = 0;
		if (root!=null){
			findLeaves(root);
		}
		return numLeaves;
	}
	
	public void findLeaves(TreeNode<E> node){
		if (node.hasLeft()){
			findLeaves(node.getLeft());
			if (node.hasRight())
				findLeaves(node.getRight());
		}else if (node.hasRight()){
			// if node has a right but not a left child
			findLeaves(node.getRight());
		}else{
			numLeaves++;
		}
		
	}
	
	public int numNonLeaves(){
		return numNodes - numLeaves();
	}
	
	public int getHeight(){
		return height;
	}
	
	public boolean isFull(){
		return Math.pow(2, getHeight())-1 == numNodes;
	}
	
	public void inOrderNoRecursive(){
		int numPrinted = 0;
		asString = "";
		Stack<TreeNode<E>> stack = new Stack<TreeNode<E>>();
		stack.push(root);
		TreeNode<E> temp;
		while (numPrinted < numNodes){
			while(stack.peek().hasLeft()){
				stack.push(stack.peek().getLeft());
			}
			if (!stack.peek().hasRight()){
				asString+=(stack.pop().getInfo());
				numPrinted++;
			}else{
				temp = stack.pop();
				asString+=temp.getInfo();
				stack.push(temp.getRight());
				numPrinted++;
				continue;
			}
			temp = stack.pop();
			asString += temp.getInfo();
			numPrinted++;
			if (temp.hasRight()){
				stack.push(temp.getRight());
			}
		}
	}
	
	public void inOrderNonRecursive(){
		int numPrinted = 0;
		asString = "";
		Stack<TreeNode<E>> stack = new Stack<TreeNode<E>>();
		stack.push(root);
		TreeNode<E> temp;
		while(numPrinted < numNodes){
			// first go to bottom of tree
			while (stack.peek().hasLeft() || stack.peek().hasRight()){
				if (stack.peek().hasLeft()){
					stack.push(stack.peek().getLeft());
				}else{
					stack.push(stack.peek().getRight());
				}
			}
			asString += stack.pop();
			numPrinted ++;
			while (!stack.peek().hasRight()){
				asString += stack.pop();
				numPrinted ++;
				if (numPrinted == numNodes){
					return;
				}
			}
			temp = stack.pop();
			stack.push(temp.getRight());
		}
	}
}
