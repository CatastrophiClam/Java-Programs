package usaco;

import java.io.*;
import java.util.*;
import java.lang.*;

/*
ID: Max
LANG: JAVA
TASK: holstein
*/

public class holstein {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new FileReader("holstein.in"));
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("holstein.out")));
		//BufferedReader reader = new BufferedReader(new FileReader("Test.txt.txt"));
		//PrintStream writer = System.out;
		int numVitamins = Integer.parseInt(reader.readLine());
		int[] minVitamins = new int[numVitamins];
		String[] buffer = new String[numVitamins];
		
		buffer = reader.readLine().split(" ");
		for (int i = 0; i < numVitamins; i++){
			minVitamins[i]=Integer.parseInt(buffer[i]);
		}
		
		int numFeeds = Integer.parseInt(reader.readLine());
		int[][] feeds = new int[numFeeds][numVitamins];
		for (int i = 0; i < numFeeds; i++){
			buffer = reader.readLine().split(" ");
			for (int j = 0; j < numVitamins; j++){
				feeds[i][j] = Integer.parseInt(buffer[j]);
			}
		}
		
		ArrayList<ArrayList<Integer>> combs = new ArrayList<ArrayList<Integer>>();
		for (int i = 1; i <= numFeeds; i++){
			getCombs(combs,numFeeds);
			int[][] feedCombs = new int[i][numFeeds];
			
			for (ArrayList<Integer>j:combs){ //for every combination
				
				for (int k = 0; k < j.size(); k++){
					feedCombs[k]=feeds[j.get(k)-1];
				}
					if (larger(sum(feedCombs),minVitamins)){
						writer.print(i);
						for (int l : j){
							writer.print(" "+l);
						}
						writer.println();
						reader.close();
						writer.close();
						System.exit(0);
						return;
					}
				
			}
		}
		
	}
	
	public static void getCombs(ArrayList<ArrayList<Integer>> prevCombs, int n){
		ArrayList<Integer> c; //current
		for(int i = prevCombs.size()-1; i >=0; i--){
			c = prevCombs.get(i);
			prevCombs.remove(i);
			for (int j = n; j > c.get(c.size()-1); j--){
				prevCombs.add(i,new ArrayList<Integer>(c));
				prevCombs.get(i).add(j);
			}
		}
		if (prevCombs.size()==0){
			for (int i = 1; i <= n; i++){
				prevCombs.add(new ArrayList<Integer>());
				prevCombs.get(prevCombs.size()-1).add(i);
			}
		}
	}
	
	//return true if all elements in a are larger than b
	public static boolean larger(int[] a, int[] b){
		for (int i = 0; i < a.length; i++){
			if (b[i]>a[i]){
				return false;
			}
		}
		return true;
	}
	
	public static int[] add(int[] a, int[] b){
		int[] answer = new int[a.length];
		for (int i = 0; i < a.length; i++){
			answer[i] = a[i]+b[i];
		}
		return answer;
	}
	
	public static int[] sum(int[][] arrays){
		int[] answer = new int[arrays[0].length];
		if (arrays.length>=2){
			answer = add(arrays[0],arrays[1]);
			for (int i = 2; i < arrays.length; i++){
				answer = add(answer,arrays[i]);
			}
			return answer;
		}else{
			return arrays[0];
		}
	}

}
