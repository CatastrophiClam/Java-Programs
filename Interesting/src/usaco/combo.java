package usaco;
import java.util.*;
import java.io.*;
import java.lang.Math;

/*
ID: Max
LANG: JAVA
TASK: combo
*/

public class combo {
	static int numNums;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new FileReader("combo.in"));
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("combo.out")));
		
		numNums = Integer.parseInt(reader.readLine());
		String[] t1 = reader.readLine().split(" ");
		String[] t2 = reader.readLine().split(" ");
		
		int[] c1 = new int[3];
		int[] c2 = new int[3];
		for (int i = 0; i < 3; i++){
			c1[i] = Integer.parseInt(t1[i]);
			c2[i] = Integer.parseInt(t2[i]);
		}
		
		//System.out.println(overlap(c1[0],c2[0]));
		//System.out.println(overlap(c1[1],c2[1]));
		//System.out.println(overlap(c1[2],c2[2]));
		writer.println((int)Math.pow(min(5,numNums),3)*2-overlap(c1[0],c2[0])*overlap(c1[1],c2[1])*overlap(c1[2],c2[2]));
		writer.close();
		reader.close();
		System.exit(0);
		
	}
	
	public static int overlap(int a, int b){
		if (a == b){
			return min(5,numNums);
		}
		int count = 0;
		int actual;
		HashSet<Integer> visited = new HashSet<Integer>();
		for (int i = a-2; i <= a+2; i++){
			if (i<=0){
				actual = numNums+i;
			}else if(i > numNums){
				actual = i-numNums;
			}else{
				actual = i;
			}
			if (visited.contains(actual)){
				continue;
			}
			visited.add(actual);
			if (Math.abs(findUpDist(actual,b))<=2 || Math.abs(findBotDist(actual,b))<=2){
				count++;
			}
		}
		return count;
	}
	
	public static int findUpDist(int a, int b){
		return (max(a,b)-min(a,b));
	}
	
	public static int findBotDist(int a, int b){
		return min(a,b)+numNums-max(a,b);
	}
	
	public static int findDist(int a, int b){
		return min(findUpDist(a,b),findBotDist(a,b));
	}
	
	public static int max(int a,int b){
		if (a>b){
			return a;
		}
		return b;
	}
	
	public static int min(int a, int b){
		if (a<b){
			return a;
		}
		return b;
	}

}
