package ccc;
import java.util.*;
import java.io.*;
public class s5_1999 {
	static String[][] strings;
	static HashMap<String,Integer> key;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int numCases = scan.nextInt();
		strings = new String[numCases][3];
		for (int i = 0; i < numCases; i++){
			for (int j = 0; j < 3; j++){
				strings[i][j] = scan.nextLine();
			}
		}
		key = new HashMap<String,Integer>();
		find(0);
		
	}
	
	public static void find(int n){
		for (int i = 0; i < strings[n].length; i++){
			
		}
	}

}
