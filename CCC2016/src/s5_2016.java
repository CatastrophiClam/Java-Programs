import java.util.*;
import java.io.*;
public class s5_2016 {
	static HashSet<Integer> allKeys;
	static int numAlive;
	static boolean[] theStart;
	static int len;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);
		String[] input = reader.nextLine().split(" ");
		len = Integer.parseInt(input[0]);
		long gen = Integer.parseInt(input[1]);
		boolean[] current;
		boolean[] next = new boolean[len];
		theStart = new boolean[len];
		allKeys = new HashSet<Integer>();
		
		String line = reader.nextLine();
		for (int i = 0; i < len; i++){
			theStart[i]=(line.charAt(i)=='1');
		}
		current = theStart;
		genKeys(current);
		
		int shift;
		
		boolean[][] store = {current,next};
		int currentAlive = 0;
		int currentTotal = 0;
		for (long i = 1; i <= gen; i++){
			currentAlive = 0;
			currentTotal = 0;
			for (int j = 1; j < len-1; j++){
				store[1][j]= ((store[0][j-1]||store[0][j+1])&&!(store[0][j-1]&&store[0][j+1]));
				if (store[1][j]){
					currentAlive++;
					currentTotal+=j;
				}
			}
			store[1][0]= ((store[0][len-1]||store[0][1])&&!(store[0][len-1]&&store[0][1]));
			store[1][len-1]= ((store[0][len-2]||store[0][0])&&!(store[0][len-2]&&store[0][0]));
			if (store[1][0]){
				currentAlive++;
			}
			if (store[1][len-1]){
				currentAlive++;
				currentTotal+=len-1;
			}
			
			if (allKeys.contains(currentTotal)&&numAlive==currentAlive){
				//assume we found a rotation
				shift = findShift(store[1]);
				if (shift!=-1){
					int endShift = (int)((shift*(gen/i))%len);
					int gensLeft = (int)(gen%i);
					store[0] = theStart;
					store[1] = new boolean[len];
					for (int k = 1; k <= gensLeft; k++){
						for (int j = 1; j < len-1; j++){
							store[1][j]= ((store[0][j-1]||store[0][j+1])&&!(store[0][j-1]&&store[0][j+1]));
							if (store[1][j]){
								currentAlive++;
								currentTotal+=j;
							}
						}
						store[1][0]= ((store[0][len-1]||store[0][1])&&!(store[0][len-1]&&store[0][1]));
						store[1][len-1]= ((store[0][len-2]||store[0][0])&&!(store[0][len-2]&&store[0][0]));
						store[0] = store[1];
						store[1] = new boolean[len];
					}
					int temp;
					for (int j = 0; j < len; j++){
						temp = (j+endShift)%len;
						if (store[0][temp]){
							System.out.print("1");
						}else{
							System.out.print("0");
						}
					}
				}
			}
			
			store[0] = store[1];
			store[1] = new boolean[len];
		}
		
		//print out
		for (int i = 0; i < len; i++){
			if (store[0][i]){
				System.out.print("1");
			}else{
				System.out.print("0");
			}
		}
	}
	
	public static int findShift(boolean[] now){
		int temp;
		outer:
		for (int i = 0; i < len-1; i++){
			for (int j = 0; j < len; j++){
				temp =(j+i)%len;
				if (theStart[temp]!=now[temp]){
					continue outer;
				}
			}
			return i;
		}
		return -1;
	}
	
	public static void genKeys(boolean[]start){
		int numT=0; //number of alive cells;
		int total = 0;
		int n = start.length;
		for (int i = 0; i < n; i++){
			if (start[i]){
				numT++;
				total+=i;
			}
		}
		numAlive = numT;
		allKeys.add(total);
		for (int i = 1; i < start.length; i++){
			if (start[i-1]){
				total+=n-1;
				total -= numT+1;
			}else{
				total-=numT;
			}
			if (!allKeys.contains(total)){
				allKeys.add(total);
			}
		}
	}

}
