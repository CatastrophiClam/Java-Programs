package usaco;

import java.io.*;
import java.util.*;

/*
ID: Max
LANG: JAVA
TASK: nocows
*/

public class nocows {
	
	private static long[][] dict;
	private static long[][] totals;
	
	public static void main(String[] args) throws IOException{
		//BufferedReader reader = new BufferedReader(new FileReader("nocows.in"));
		//PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("nocows.out")));
		BufferedReader reader = new BufferedReader(new FileReader("Test.txt.txt"));
		PrintStream writer = System.out;
		
		String[] buffer = reader.readLine().split(" ");
		int numNodes = Integer.parseInt(buffer[0]);
		int height = Integer.parseInt(buffer[1]);
		
		dict = new long[height+1][numNodes+1];
		totals = new long[height+1][numNodes+1];
		dict[2][3] = 1;
		totals[2][3] = 1;
		for (int i = 1; i <= height; i++){
			totals[i][1] = 1;
		}
		
		for (int i = 3; i <= height; i++){
			for (int j = 3; j <= numNodes; j+= 2){
				for (int k = 1; k <= j-2; k += 2){
					dict[i][j]+=dict[i-1][k]*totals[i-1][j-1-k]*2;
				}
				dict[i][j]-=dict[i-1][(j-1)/2]*dict[i-1][(j-1)/2];
				totals[i][j] = totals[i-1][j]+dict[i][j];
			}
		}
		writer.println(dict[height][numNodes]%9901);
		
		/**
		for (int i = 0; i <= height; i++){
			for (int j = 0; j <= numNodes; j++){
				writer.print(dict[i][j]+" ");
			}
			writer.println();
		}
		**/
		
		reader.close();
		writer.close();
		System.exit(0);
	}
}









