package dataStructures;

public class FenwickTree {
	private int size;
	private int[] vals;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4};
		FenwickTree tree = new FenwickTree(4);
		for (int i = 0; i< arr.length; i++){
			tree.adjust(i+1, arr[i]);
		}
		tree.printVals();
		System.out.println(tree.RSQ(1,5));
		tree.adjust(1, 3);
		tree.printVals();
		System.out.println(tree.RSQ(1,5));
	}
	
	public FenwickTree(int size){
		this.size = size;
		vals = new int[size+1];
	}
	
	public FenwickTree(int[] arr){
		vals = new int[arr.length+1];
		size = vals.length;
		for (int i = 1; i < vals.length; i++){
			for (int j = i-LSBit(i)+1; j <= i; j++){
				vals[i]+=arr[j-1];
			}
		}
	}
	
	public int RSQ(int ind){
		int sum = 0;
		while(ind != 0){
			sum += vals[ind];
			ind -= LSBit(ind);
		}
		return sum;
	}
	
	//includes start, excludes end
	public int RSQ(int start, int end){
		return RSQ(end-1)-RSQ(start-1);
	}
	
	public void adjust(int ind, int val){
		do{
			vals[ind]+=val;
			ind += LSBit(ind);
		}while(ind <= size);
	}
	
	public int LSBit(int num){
		return num&(-num);
	}
	
	public void printVals(){
		for (int i:vals){
			System.out.print(i+" ");
		}
		System.out.println();
	}

}
