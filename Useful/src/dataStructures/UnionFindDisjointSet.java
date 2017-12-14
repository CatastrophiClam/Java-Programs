package dataStructures;

public class UnionFindDisjointSet {
	private int size;
	private int[] parent;
	private int[] rank;
	
	public static void main(String[]args){
		UnionFindDisjointSet set = new UnionFindDisjointSet(10);
		set.union(1, 2);
		System.out.println(set.isSame(1, 2));
		set.union(2, 3);
		System.out.println(set.isSame(1, 3));
		System.out.println(set.isSame(1, 4));
	}
	
	public UnionFindDisjointSet(int size){
		this.size = size;
		parent = new int[size];
		for (int i = 0; i < size; i++){
			parent[i] = i;
		}
		rank = new int[size];
	}
	
	public void union(int a, int b){
		if (rank[a] > rank[b]){
			parent[b] = a;
			rank[a] += rank[b];
		}else{
			parent[a] = b;
			rank[b] += rank[a];
		}
	}
	
	public boolean isSame(int a, int b){
		return getRoot(a)==getRoot(b);
	}
	
	public int getRoot(int a){
		if (parent[a]!=a){
			int root = getRoot(parent[a]);
			parent[a] = root;
			return root;
		}else{
			return a;
		}
	}
}




