package competitiveProgramming;
import java.util.*;
import java.io.*;

public class Potentiometers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(new BufferedInputStream(System.in));
		
		int N = reader.nextInt();
		int[] vals;
		String buffer;
		FenwickTree tree;
		int caseNum = 0;
		int i1, i2;
		while(N != 0){
			
			vals = new int[N];
			tree = new FenwickTree(N);
			caseNum++;
			System.out.printf("Case %d:", caseNum);
			for(int j = 0; j < N; j++){
				vals[j]=reader.nextInt();
				tree.adjust(j+1, vals[j]);
			}
			
			while(!(buffer = reader.next()).equals("END")){
				i1 = reader.nextInt();
				i2 = reader.nextInt();
				if (buffer.equals("S")){
					tree.adjust(i1, i2-vals[i1-1]);
				}else{
					System.out.println(tree.RSQ(i1,i2+1));
					System.out.println();
				}
			}
			N = reader.nextInt();
		}
	}

}

class FenwickTree {
	private int size;
	private int[] vals;
	
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
