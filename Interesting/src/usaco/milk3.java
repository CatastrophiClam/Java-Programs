package usaco;

import java.io.*;
import java.util.*;

/*
ID: Max
LANG: JAVA
TASK: milk3
*/

public class milk3 {
	
	static ArrayList<Integer> outcomes;
	static HashSet<ArrayList<Integer>> visited;
	static int A,B,C;
	static int[] maxis;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new FileReader("milk3.in"));
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("milk3.out")));
		//BufferedReader reader = new BufferedReader(new FileReader("Test.txt.txt"));
		//PrintStream writer = System.out;
		String[] buffer = reader.readLine().split(" ");
		maxis = new int[3];
		maxis[0] = Integer.parseInt(buffer[0]);
		maxis[1] = Integer.parseInt(buffer[1]);
		maxis[2] = Integer.parseInt(buffer[2]);
		outcomes = new ArrayList<Integer>();
		visited = new HashSet<ArrayList<Integer>>();
		findAll(0,0,maxis[2]);
		writer.print(outcomes.get(0));
		for (int i = 1; i < outcomes.size(); i++){
			writer.print(" "+outcomes.get(i));
		}
		writer.println();
		reader.close();
		writer.close();
		System.exit(0);
	}
	
	public static void findAll(int A, int B, int C){
		ArrayList<Integer> now = new ArrayList<Integer>();
		now.add(A);
		now.add(B);
		now.add(C);
		//System.out.println("Checking "+now);
		visited.add(now);
		if (A == 0){
			for (int i = 0; i < outcomes.size(); i++){
				if (outcomes.get(i)==C){
					break;
				}else if(outcomes.get(i)>C){
					outcomes.add(i,C);
					break;
				}
			}
			if (outcomes.size()==0){
				outcomes.add(C);
			}else if (outcomes.get(outcomes.size()-1)<C){
				outcomes.add(C);
			}
		}
		ArrayList<Integer> temp;
		for (int i = 0; i < 3; i ++){
			for (int j = 0; j < 3; j++){
				if (j!= i){
					temp = pour(now,i,j);
					if (!visited.contains(temp)){
						findAll(temp.get(0),temp.get(1),temp.get(2));
					}
				}
			}
		}
	}
	
	//pour bucket at index a into index b
	public static ArrayList<Integer> pour(ArrayList<Integer> buckets, int a, int b){
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < 3; i ++){
			if (i == a){
				result.add(max(0,buckets.get(a)-(maxis[b]-buckets.get(b))));
			}else if (i == b){
				result.add(min(maxis[b],buckets.get(b)+buckets.get(a)));
			}else{
				result.add(buckets.get(i));
			}
		}
		return result;
	}
	
	public static int min(int a, int b){
		if (a < b){
			return a;
		}
		return b;
	}
	
	public static int max(int a, int b){
		if (a > b){
			return a;
		}
		return b;
	}
	
	public static void insert(int a, ArrayList<Integer> array){
		for (int i = 0; i < array.size(); i++){
			if (array.get(i) > a){
				array.add(i,a);
				return;
			}
		}
		array.add(a);
	}

}
