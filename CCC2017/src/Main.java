import java.util.*;
public class Main {
	
	static int[][] network;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String[] buffer;
		buffer = scan.nextLine().split(" ");
		int numStations = Integer.parseInt(buffer[0]);
		int numLines = Integer.parseInt(buffer[1]);
		int numActions = Integer.parseInt(buffer[2]);
		
		int[] lineSizes = new int[numLines+1]; //starts at 1, takes line gives num of stations
		int[] tempLineSizes = new int[numLines+1];
		
		buffer = scan.nextLine().split(" ");
		int[] all = new int[buffer.length]; //starts at 0, takes station, gives line
		int[] index = new int[buffer.length];  //takes station, gives position on line
		for (int i = 0; i < buffer.length; i++){
			all[i] = Integer.parseInt(buffer[i]);
			lineSizes[all[i]]++;
			tempLineSizes[all[i]]++;
		}
		
		network = new int[numLines][]; //starts at 0
		for (int i = 0; i<network.length; i++){
			network[i] = new int[lineSizes[i+1]+1];
		}
		
		buffer = scan.nextLine().split(" ");
		for (int i = 0; i < buffer.length; i++){
			index[i] = network[all[i]-1].length-tempLineSizes[all[i]];
			put(index[i], Integer.parseInt(buffer[i]), network[all[i]-1]);
			tempLineSizes[all[i]]--;
		}
		
		int t1, t2;
		int line;
		int ind;
		int nextInd;
		for (int i = 0; i < numActions; i++){
			buffer = scan.nextLine().split(" ");
			t1 = Integer.parseInt(buffer[1]);
			if (buffer.length == 2){
				line = all[t1-1];
				ind = index[t1-1];
				if (ind >= network[line-1].length-1){
					nextInd = 1;
				}else{
					nextInd = ind+1;
				}
				put(ind, 0-lineSizes[line],network[line-1]);
				put(nextInd, lineSizes[line],network[line-1]);
			}else{
				t2 = Integer.parseInt(buffer[2]);
				if (t2 < t1){
					System.out.println(rsq(index[t2-1],network[all[t1-1]-1])+rsq(index[t1-1],network[all[t1-1]-1].length-1,network[all[t1-1]-1]));
				}
				System.out.println(rsq(index[t1-1],index[t2-1],network[all[t1-1]-1]));
			}
		}
		
	}
	
	public static int rsq(int a, int[] target){
		int sum = 0;
		for (int i = a; i >0; i-= (i&(-i))){
			sum += target[i];
		}
		return sum;
	}
	
	public static int rsq(int a, int b, int[] target){
		return rsq(b, target) - ((a==1)? 0:rsq(a,target));
	}
	
	public static void put(int ind, int val, int[] target){
		for (int i = ind; i < target.length; i += (i&(-i))){
			target[i]+=val;
		}
	}

}
