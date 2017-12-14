package ccc;
import java.util.*;
import java.io.*;

public class MouseJourney {
	static int[][]grid;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);
		int numRows = reader.nextInt();
		int numCols = reader.nextInt();
		int numCats = reader.nextInt();
		grid = new int[numRows+1][numCols+1];
		
		for (int i =0; i <= numRows; i++){
			for (int j = 0; j <= numCols; j++){
				grid[i][j]=-1;
			}
		}
		
		int a,b;
		for (int i = 0; i < numCats; i++){
			a = reader.nextInt();
			b = reader.nextInt();
			grid[a][b]=-2;
		}
		
		System.out.println(find(numRows,numCols));
	}
	
	public static int find(int row, int col){
		if (row < 1 || col < 1){
			return 0;
		}
		if (grid[row][col]!= -1 && grid[row][col]!= -2){
			return grid[row][col];
		}
		if (grid[row][col]==-2){
			return 0;
		}
		if (row == 1 && col == 1){
			return 1;
		}
		return find(row-1,col)+find(row,col-1);
	}

}
