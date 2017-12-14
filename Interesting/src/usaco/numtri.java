package usaco;

import java.io.*;
import java.util.*;

/*
ID: Max
LANG: JAVA
TASK: numtri
*/

public class numtri {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new FileReader("numtri.in"));
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("numtri.out")));
		//BufferedReader reader = new BufferedReader(new FileReader("Test.txt.txt"));
		//PrintStream writer = System.out;
		int numRows = Integer.parseInt(reader.readLine());
		String[]buffer = new String[numRows];
		int[][] triangle = new int[numRows][];
		for (int i = 0; i < numRows; i++){
			buffer = reader.readLine().split(" ");
			triangle[i] = new int[i+1];
			for (int j = 0; j <= i; j++){
				triangle[i][j]=Integer.parseInt(buffer[j]);
			}
		}
		if (numRows > 1){
			for (int i = numRows-2; i >= 0; i--){
				for (int j = 0; j <= i; j++){
					triangle[i][j]+=max(triangle[i+1][j],triangle[i+1][j+1]);
				}
			}
		}
		writer.println(triangle[0][0]);
		reader.close();
		writer.close();
		System.exit(0);
	}
	
	public static int max(int a, int b){
		if (a > b){
			return a;
		}
		return b;
	}

}
