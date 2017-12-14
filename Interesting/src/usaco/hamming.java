package usaco;
import java.io.*;
import java.util.*;
import java.lang.Math;

/*
ID: Max
LANG: JAVA
TASK: hamming
*/

public class hamming {
	static int B,D;
	
	public static void main(String[] args) throws IOException{
		BufferedReader reader = new BufferedReader(new FileReader("hamming.in"));
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("hamming.out")));
		//BufferedReader reader = new BufferedReader(new FileReader("Test.txt.txt"));
		//PrintStream writer = System.out;
		String[]buffer = reader.readLine().split(" ");
		
		int N = Integer.parseInt(buffer[0]);
		B = Integer.parseInt(buffer[1]);
		D = Integer.parseInt(buffer[2]);
		int numNums = (int)Math.pow(2, B);
		
		String[] nums = new String[numNums];
		for (int i = 0; i < numNums; i++){
			nums[i]=toString(i);
		}
		
		ArrayList<Integer> indexes = new ArrayList<Integer>();
		for (int i = 0; i < numNums; i++){ //for each smallest value
			indexes.clear();
			indexes.add(i);
			trying:
			for (int j = i+1; j < numNums; j++){
				for (int k:indexes){
					if (!farEnough(nums[j],nums[k])){
						continue trying;
					}
				}
				indexes.add(j);
				if (indexes.size()==N){
					for(int k = 0; k < N; k++){
						writer.print(indexes.get(k));
						if (k!=N-1 &&((k+1)%10!=0)){
							writer.print(" ");
						}else{
							writer.println();
						}
					}
					reader.close();
					writer.close();
					System.exit(0);
				}
			}
		}
	}
	
	public static boolean farEnough(String a, String b){
		int count = 0;
		for (int i = 0; i < a.length(); i++){
			if (a.charAt(i)!=b.charAt(i)){
				count++;
			}
		}
		return count>=D;
	}
	
	public static String toString(int a){
		String answer = "";
		while (a != 0){
			answer = a%2 + answer;
			a = a/2;
		}
		while(answer.length()<B){
			answer = "0"+answer;
		}
		return answer;
	}
}
