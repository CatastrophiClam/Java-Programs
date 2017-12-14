package random;
import java.util.ArrayList;

public class Sudoku {
	int[][] board = new int[9][9];
	
	public Sudoku(){
		
	}
	
	public ArrayList<Integer> solve(int[][] problem){
		board = problem;
		boolean solved = false;
		
		
		
	}
	
	// for every row and column, if there's only one spot left, fill that spot
	public void checkEverything(int[][] board){
		//check all rows
		for (int[] i: board){
			
		}
		//check all columns
		for (int x = 0; x < 9; x++){
			for (int [] i : board){
				
			}
		}
	}
}
