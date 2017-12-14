package usaco;
import java.io.*;
import java.util.*;

/*
ID: Max
LANG: JAVA
TASK: runround
*/

public class runround {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new FileReader("runround.in"));
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("runround.out")));
		//BufferedReader reader = new BufferedReader(new FileReader("Test.txt.txt"));
		//PrintStream writer = System.out;
		String M = String.valueOf(Integer.parseInt(reader.readLine())+1);
		int[] num = new int[M.length()];
		for (int i = 0; i < M.length(); i++){
			num[i]=Integer.parseInt(M.substring(i,i+1));
		}
		num = cycle(num);
		for (int i = 0; i < num.length; i++){
			writer.print(num[i]);
		}
		writer.println();
		reader.close();
		writer.close();
		System.exit(0);
	}
	
	public static int[] cycle(int[] num){
		HashSet<Integer> visited = new HashSet<Integer>();
		HashSet<Integer> taken = new HashSet<Integer>();
		int index = 0;
		boolean found = false;
		int pastIndex = 0;
		int pastPastIndex = 0;
		int past3Index = 0;
		while (!found){
			visited.clear();
			taken.clear();
			index = 0;
			//for(int i:num){
			//	System.out.print(i);
			//}
			//System.out.println();
			outer:
			while (!visited.contains(index)){
				past3Index = pastPastIndex;
				pastPastIndex = pastIndex;
				pastIndex = index;
				visited.add(index);
				if (taken.contains(num[index])){
					for (int i = num.length-1; i >= 0; i--){
						if (num[i]==num[index]){
							pastIndex = i;
							break outer;
						}
					}
				}
				taken.add(num[index]);
				index = (num[index]+index)%num.length;
			}
			if (pastPastIndex > pastIndex){
				pastIndex = pastPastIndex;
			}
			if (past3Index > pastIndex){
				pastIndex = past3Index;
			}
			if (visited.size() == num.length && index == 0){
				return num;
			}else{
				num = increment(num, num.length-1);
			}
		}
		return num;
	}
	
	public static int[] increment(int[] num, int from){
		HashSet<Integer> taken = new HashSet<Integer>();
		for (int i = 0; i < from; i++){
			taken.add(num[i]);
		}
		boolean found = false;
		for (int i = num[from]+1; i <= 9; i++){
			if (!taken.contains(i)){
				num[from] = i;
				found = true;
				taken.add(i);
				break;
			}
		}
		if (!found){
			if (from == 0){
				num = new int[num.length+1];
				for (int i = 0; i < num.length; i++){
					num[i]=i+1;
				}
				return num;
			}else{
				return increment(num,from-1);
			}
		}else{
			int j = from+1;
			for (int i = 1; i < 9 && j < num.length; i++){
				if (!taken.contains(i)){
					num[j]=i;
					j++;
				}
			}
			return num;
		}
	}

}
