package usaco;

import java.io.*;
import java.util.*;

/*
ID: Max
LANG: JAVA
TASK: sort3
*/

public class sort3 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new FileReader("sort3.in"));
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("sort3.out")));
		int n = Integer.parseInt(reader.readLine());
		int[] counts = new int[3];
		int[] numbers = new int[n];
		
		for (int i = 0; i < n; i++){
			numbers[i] = Integer.parseInt(reader.readLine());
			counts[numbers[i]-1]++;
		}
		
		int[][] sections = new int[3][3];
		int leftOvers = 0;
		int totalMoves = 0;
		for (int i = 0; i < n; i++){
			if (i < counts[0]){
				sections[0][numbers[i]-1]++;
			}else if(i < counts[1]+counts[0]){
				sections[1][numbers[i]-1]++;
			}else{
				sections[2][numbers[i]-1]++;
			}
		}
		
		totalMoves += min(sections[0][1],sections[1][0]);
		leftOvers += max(sections[0][1],sections[1][0])-min(sections[0][1],sections[1][0]);
		totalMoves += min(sections[0][2],sections[2][0]);
		leftOvers += max(sections[0][2],sections[2][0])-min(sections[0][2],sections[2][0]);
		totalMoves += min(sections[1][2],sections[2][1]);
		leftOvers += max(sections[1][2],sections[2][1])-min(sections[1][2],sections[2][1]);
		
		totalMoves += leftOvers/3*2;
		writer.println(totalMoves);
		
		reader.close();
		writer.close();
		System.exit(0);
	}
	public static int min(int a, int b){
		if (a > b)
			return b;
		return a;
	}
	
	public static int max(int a, int b){
		if(a > b)
			return a;
		return b;
	}

}
