package usaco;
import java.util.*;
import java.io.*;

/*
ID: Max
LANG: JAVA
TASK: transform
*/

public class transform {
	
	static char[][] originalSquare;
	static int len;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new FileReader("transform.in"));
		//BufferedReader reader = new BufferedReader(new FileReader("Test.txt.txt"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("transform.out")));
		//PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("Files/Out")));
		len = Integer.parseInt(reader.readLine());
		originalSquare = new char[len][len];
		char[][] square = new char[len][len];
		
		String input;
		for (int i = 0; i < len; i++){
			input = reader.readLine();
			for (int j = 0; j < len; j++){
				originalSquare[i][j]=input.charAt(j);
			}
		}
		
		for (int i = 0; i < len; i++){
			input = reader.readLine();
			for (int j = 0; j < len; j++){
				square[i][j]=input.charAt(j);
			}
		}
		
		boolean same = false;
		if (isSame(square)){
			same = true;
		}
		
		int checker;
		checker = checkRotation(square);
		if (checker > 0){
			out.println(checker);
			out.close();
			reader.close();
			System.exit(0);
			return;
		}
		
		square = reflect(square);
		if (isSame(square)){
			out.println(4);
			out.close();
			reader.close();
			System.exit(0);
			return;
		}
		
		checker = checkRotation(square);
		if (checker>0){
			out.println(5);
			out.close();
			reader.close();
			System.exit(0);
			return;
		}
		
		if (same){
			out.println(6);
			out.close();
			reader.close();
			System.exit(0);
			return;
		}
		
		out.println(7);
		
		out.close();
		reader.close();
		System.exit(0);
	}
	
	public static int checkRotation(char[][] square){
		char[][]tempSquare;
		tempSquare = rotate(square);
		if (isSame(tempSquare)){
			return 1;
		}
		tempSquare = rotate(tempSquare);
		if (isSame(tempSquare)){
			return 2;
		}
		tempSquare = rotate(tempSquare);
		if (isSame(tempSquare)){
			return 3;
		}
		return -1;
	}
	
	public static char[][] rotate(char[][] square){
		char[][]newSquare = new char[len][len];
		for (int i = 0; i < len; i++){
			for (int j = 0; j < len; j++){
				newSquare[i][j] = square[len-j-1][i];
			}
		}
		return newSquare;
	}
	
	public static char[][] reflect(char[][]square){
		char[][] newSquare = new char[len][len];
		for (int i = 0; i < len; i++){
			for (int j = 0; j < len; j++){
				newSquare[i][j] = square[i][len-j-1];
			}
		}
		return newSquare;
	}
	
	public static boolean isSame(char[][]square){
		for (int i = 0; i < len; i++){
			for (int j = 0; j < len; j++){
				if (square[i][j]!=originalSquare[i][j]){
					return false;
				}
			}
		}
		return true;
	}

}
