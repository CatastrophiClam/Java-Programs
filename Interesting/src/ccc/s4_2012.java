package ccc;
import java.util.*;
import java.io.*;
import java.lang.Math;

public class s4_2012 {
	
	static HashSet<String> processed;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		File file = new File("Test.txt.txt");
		Scanner reader = new Scanner(file);
		int num = 6;//reader.nextInt();
		int[][] coins;
		processed = new HashSet<String>();
		ArrayDeque<int[][]> queue = new ArrayDeque<int[][]>();
		ArrayList<int[][]> tempPossibilities = new ArrayList<int[][]>();
		int[][] toProcess;
		int count;
		int tempCount;
		String temp;
		String answer;
		
		while (num!= 0){
			processed.clear();
			queue.clear();
			count = 0;
			tempCount=0;
			answer = "";
			for (int i = 1; i <= num; i++){
				answer += String.valueOf(i);
				answer+="|";
			}
			
			coins = new int[num][num];
			for (int i = 0; i < num; i++){
				coins[i][0]=reader.nextInt();
			}
			queue.add(coins);
			
			while(!queue.isEmpty()){
				if (tempCount > 0){
					tempCount--;
				}
				
				toProcess = queue.remove();
				tempPossibilities = generate(toProcess);
				
				for (int i = 0; i < tempPossibilities.size(); i++){
					temp = toString(tempPossibilities.get(i));
					if (temp.equals(answer)){
						System.out.println(count+1);
						break;
					}else{
						if (!processed.contains(temp)){
							processed.add(temp);
							queue.add(tempPossibilities.get(i));
						}
					}
				}
				
				if (tempCount == 0){
					tempCount = queue.size();
					count++;
				}
			}
			System.out.println("IMPOSSIBLE");
			
			num = reader.nextInt();
		}
	}
	
	public static int findTop(int[] stack){
		int i = -1;
		while (stack[i+1]!= 0){
			i++;
		}
		return i;
	}
	
	public static ArrayList<int[][]> generate(int[][] pos){
		int top;
		int topInd;
		int[][] result = new int[pos.length][pos.length];
		int[] topInds = new int[pos.length];
		int left, right;
		ArrayList<int[][]>results = new ArrayList<int[][]>();
		for (int i = 0; i < pos.length; i++){
			topInds[i] = findTop(pos[i]);
		}
		for (int i = 0; i < pos.length;i++){
			left = i-1;
			if (left > 0){
				if (topInds[left]!=-1){
					left = topInds[left];
				}else{
					left = 0;
				}
			}else{
				left = 1000;
			}
			right = i+1;
			if (right < pos.length){
				if (topInds[right]!=-1){
					right = topInds[right];
				}else{
					right = 0;
				}
			}else{
				right = 1000;
			}
			if (pos[i][topInds[i]]<left){
				
			}
		}
		return results;
	}
	
	public static String toString(int[][] num){
		String string = "";
		for (int i = 0; i < num.length; i++){
			for (int j = 0; num[i][j]!=0&&j<num[i].length; j++){
				string+=String.valueOf(num[i][j]);
			}
			string+="|";
		}
		return string;
	}

}
