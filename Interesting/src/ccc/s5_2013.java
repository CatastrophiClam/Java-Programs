package ccc;

import java.io.*;
import java.util.*;
import java.lang.Math;
public class s5_2013 {
	static int[]key;

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		File file = new File("Test.txt.txt");
		Scanner reader = new Scanner(System.in);
		int num = reader.nextInt();
		key = new int[num+1];
		for (int i=0; i < key.length; i++){
			key[i]=-1;
		}
		key[1]=0;
		key[2]=1;
		System.out.println(find(num));
	}
	
	public static int find(int n){
		if (key[n]!=-1){
			return key[n];
		}
		ArrayList<Integer>factors = findFactors(n);
		int tempCost;
		int minCost = 2000000000;
		int a;
		int cost;
		int past;
		for (int i = 0; i < factors.size(); i++){
			a = n/factors.get(i);
			cost = factors.get(i)-1;
			past = cost*a;
			tempCost = find(past)+cost;
			if (tempCost < minCost){
				minCost = tempCost;
			}
		}
		key[n]=minCost;
		return minCost;
	}
	
	public static ArrayList<Integer> findFactors(int n){
		ArrayList<Integer>factors = new ArrayList<Integer>();
		for (int i = 2; i <=(int)(Math.sqrt(n)); i++){
			if (n%i==0){
				factors.add(i);
			}
		}
		if (factors.size()==0){
			factors.add(n);
		}
		return factors;
	}
	
	

}
