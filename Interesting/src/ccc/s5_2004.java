package ccc;
import java.util.*;
import java.io.*;

public class s5_2004 {
	static int rows, cols;
	static String[][] map;
	static int[][][] scores; //first 2 indices are coords, third is approach from (0 is bottom, 1 is left, 2 is top)

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(new File("Test.txt.txt"));
		String[] input = reader.nextLine().split(" ");
		rows = Integer.parseInt(input[0]);
		cols = Integer.parseInt(input[1]);
		for (int i = 0; i < rows; i++){
			map[i] = reader.nextLine().split("");
		}
		scores = new int[rows][cols][3];
		findMax(rows-1,cols-1,3);
		System.out.println(max(scores[rows-1][cols-1][1],scores[rows-1][cols-1][2]));
	}
	
	public static void findMax(int row, int col, int from){
		if ((scores[row][col][0]!=0||from==0)&&(scores[row][col][1]!=0||from==1)&&(scores[row][col][2]!=0||from==2)){
			return;
		}
		if (row==0&&col==0){
			return;
		}
		if (row != rows-1 && from != 0){
			findMax(row+1,col,2);
			scores[row][col][0] = max(scores[row+1][col][0],scores[row+1][col][1]);
		}
	}
	
	public static int max(int a, int b){
		if (a>b){
			return a;
		}
		return b;
	}

}
