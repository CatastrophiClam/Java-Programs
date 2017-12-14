package usaco;

/*
ID: Max
LANG: JAVA
TASK: dualpal
*/

import java.util.*;
import java.lang.Math;
import java.io.*;

public class dualpal {
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new FileReader("Files/In"));
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("Files/Out")));
		String[] temp = reader.readLine().split(" ");
		int numNums = Integer.parseInt(temp[0]);
		int floor = Integer.parseInt(temp[1])+1;
		int palCount;  // number of palindromes in other bases
		int foundCount = 0;  // number of integers found
		boolean found = false;
		while (!found){
			palCount = 0;
			for (int i = 2; i <= 10; i++){
				if (isPal(convertBase(floor,i))){
					palCount++;
					if (palCount == 2){
						writer.println(floor);
						foundCount++;
						break;
					}
				}
			}
			if (foundCount == numNums){
				break;
			}
			floor++;
		}
		reader.close();
		writer.close();
		System.exit(0);
	}
	
	public static boolean isPal(String num){
		for (int i = 0; i <= num.length()/2;i++){
			if (num.charAt(i) != num.charAt(num.length()-1-i)){
				return false;
			}
		}
		return true;
	}
	
	public static String convertBase(int num, int base){
		String key = "0123456789ABCDEFGHIJK";
		String answer = "";
		int temp;
		//find maximum power
		int maxPower = 0;
		for (;Math.pow(base, maxPower+1)<=num;maxPower++){
		}
		for (int i = maxPower; i >= 0; i--){
			temp = num/(int)Math.pow(base, i);
			num = num%(int)Math.pow(base,i);
			answer += String.valueOf(key.charAt(temp));
		}
		return answer;
	}

}
