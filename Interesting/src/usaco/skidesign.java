package usaco;

import java.io.*;
import java.util.*;

/*
ID: Max
LANG: JAVA
TASK: skidesign
*/

public class skidesign {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new FileReader("skidesign.in"));
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("skidesign.out")));
		int n = Integer.parseInt(reader.readLine());
		int[] hillHeights = new int[n];
		int min = 100;
		int max = 0;
		for (int i = 0; i < n; i++){
			hillHeights[i] = Integer.parseInt(reader.readLine());
			if (hillHeights[i]<min){
				min = hillHeights[i];
			}
			if (hillHeights[i]> max){
				max = hillHeights[i];
			}
		}
		if (max - min <= 17){
			writer.println(0);
		}else{
			int[] minCosts = new int[101]; //cost of bringing min up to index
			int[] maxCosts = new int[101]; //cost of bringing max down to index
			for (int i = 0; i < hillHeights.length; i++){
				for (int j = 1; j <= 100; j++){
					if (hillHeights[i]<j){
						minCosts[j]+=(j-hillHeights[i])*(j-hillHeights[i]);
					}else{
						maxCosts[j]+=(hillHeights[i]-j)*(hillHeights[i]-j);
					}
				}
			}
			int minTotalCost = 2000000000;
			int tempCost;
			for (int i = min; i <= max-17; i++){
				tempCost = minCosts[i]+maxCosts[i+17];
				if (tempCost < minTotalCost){
					minTotalCost = tempCost;
				}
			}
			writer.println(minTotalCost);
		}
		reader.close();
		writer.close();
		System.exit(0);
		
		
	}

}
