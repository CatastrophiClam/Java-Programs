package dataStructures;
import java.util.Random;
import java.util.ArrayList;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random = new Random(5);
		BinaryTree<Integer> tree = new BinaryTree<Integer>();
		tree.add(10);
		tree.add(5);
		tree.add(11);
		tree.add(2);
		tree.add(7);
		tree.add(13);
		tree.add(1);
		tree.add(3);
		tree.add(12);
		tree.add(17);
		tree.add(4);
		tree.add(14);
		tree.add(16);
		tree.add(15);
		tree.add(18);
		tree.rebalance();
		//tree.inOrderNoRecursive();
		while (tree.hasNext()){
			System.out.println(tree.next());
		}
		while (tree.hasPrevious()){
			System.out.println(tree.previous());
		}
	}
}
