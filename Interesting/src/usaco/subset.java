package usaco;
import java.io.*;
import java.util.*;
import java.lang.Math;

/*
ID: Max
LANG: JAVA
TASK: subset
*/

public class subset {
	public static int N;
	public static int count;
	static long[][] all;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		//BufferedReader reader = new BufferedReader(new FileReader("subset.in"));
		//PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("subset.out")));
		BufferedReader reader = new BufferedReader(new FileReader("Test.txt.txt"));
		PrintStream writer = System.out;
		
		count = 0;
		N = Integer.parseInt(reader.readLine());
		if (N == 1 || N == 2){
			writer.println(0);
		}else if(N == 3){
			writer.println(1);
		}else{
			//check if possible
			int sum = N*(N+1)/2;
			if (sum%2==0){
				//find
				int goal = sum/2;
				all = new long[goal+1][N+1];
				for (int i = 0; i < goal+1; i++){
					for (int j = 0; j < N+1; j++){
						all[i][j] = -1;
					}
				}
				find(goal, N);
					writer.println(all[goal][N]/2);
			}else{
				writer.println(0);
			}
		}
		reader.close();
		writer.close();
		System.exit(0);
	}
	
	public static long find(int goal, int from){
		if (all[goal][from]!=-1){
			return all[goal][from];
		}
		if (goal == 0){
			return 1;
		}
		long total = 0;
		for (int i = min(from,goal); i > 0; i--){
				if (i*(i+1)/2>=goal){
					total += find(goal-i, i-1);
				}else{
					break;
				}
			
		}
		all[goal][from] = total;
		return total;
	}
	
	public static int min(int a, int b){
		if (a>b) return b;
		return a;
	}
	
}
	
	
