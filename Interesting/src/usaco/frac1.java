package usaco;

import java.util.*;
import java.io.*;

/*
ID: Max
LANG: JAVA
TASK: frac1
*/

public class frac1 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new FileReader("frac1.in"));
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("frac1.out")));
		//BufferedReader reader = new BufferedReader(new FileReader("Test.txt.txt"));
		//PrintStream writer = System.out;
		int n = Integer.parseInt(reader.readLine());
		writer.println("0/1");
		
		ArrayList<ArrayList<int[]>> nums = new ArrayList<ArrayList<int[]>>();
		for(int i = 1; i < n; i++){
			nums.add(new ArrayList<int[]>());
			for (int j = n; j > i; j--){
				if (gcf(i,j)==1)
					//System.out.println(gcf(i,j));
					nums.get(nums.size()-1).add(new int[]{i,j});
			}
			if (nums.get(i-1).size()==0){
				nums.remove(i-1);
			}
		}
		
		double min;
		int ind = -1;
		double temp;
		int[] process;
		
		while(nums.size()>0){
			min = 10000;
			for (int i = 0; i < nums.size(); i++){
				process = nums.get(i).get(0);
				temp = process[0]/(double)(process[1]);
				if (temp < min){
					min = temp;
					ind = i;
				}
			}
			writer.println(nums.get(ind).get(0)[0]+"/"+nums.get(ind).get(0)[1]);
			nums.get(ind).remove(0);
			if (nums.get(ind).size()==0){
				nums.remove(ind);
			}
		}
		
		writer.println("1/1");
		reader.close();
		writer.close();
		System.exit(0);
	}
	
	public static int gcf (int a, int b){
		if(a > b){
			a = a%b;
			if (a == 0){
				return b;
			}else{
				return gcf(a,b);
			}
		}else{
			b = b%a;
			if (b == 0){
				return a;
			}else{
				return gcf(a,b);
			}
		}
	}

}
