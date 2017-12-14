package ccc;
import java.io.*;
import java.util.*;

public class s3_2008 {
	
	static boolean found = false;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(new File("Test.txt.txt"));
		int numCases = Integer.parseInt(reader.nextLine());
		for (int i = 0; i < numCases; i++){
			doCase(reader);
		}
	}
	
	public static void doCase(Scanner reader){
		int rows = Integer.parseInt(reader.nextLine());
		int cols = Integer.parseInt(reader.nextLine());
		String[][] grid = new String[rows][cols];
		int[][] visited = new int[rows][cols];
		for (int i = 0; i < rows; i++){
			grid[i]=reader.nextLine().split("");
		}
		visited[0][0]=0;
		find(0,0,grid,visited,rows,cols);
		System.out.println(visited[rows-1][cols-1]);
		
	}
	
	public static boolean canGo(int r, int c, String[][]grid,int[][]visited,int rows,int cols){
		if (r >= 0 && c >= 0 && r < rows && c < cols && !(r==0&&c==0)){
			if (!grid[r][c].equals("*") && visited[r][c] == 0){
				return true;
			}
		}
		return false;
	}
	
	public static void find(int r, int c, String[][]grid,int[][]visited,int rows, int cols){
		ArrayDeque<int[]> queue = new ArrayDeque<int[]>();
		queue.add(new int[] {r,c});
		int[] current;
		while(!queue.isEmpty()){
			
			current = queue.remove();
			if (current[0]==rows-1&&current[1] == cols-1){
				visited[rows-1][cols-1]+=1;
				return;
			}
			r = current[0];
			c = current[1];
			
			switch(grid[current[0]][current[1]]){
			case "+":
			case "-":
				if (canGo(r,c-1,grid,visited,rows,cols)){
					visited[r][c-1]= visited[r][c]+1;
					queue.add(new int[]{r,c-1});
				}
				if (canGo(r,c+1,grid,visited,rows,cols)){
					visited[r][c+1]= visited[r][c]+1;
					queue.add(new int[]{r,c+1});
				}
			case "|":
				if (!grid[current[0]][current[1]].equals("-")){
					if (canGo(r-1,c,grid,visited,rows,cols)){
						visited[r-1][c]= visited[r][c]+1;
						queue.add(new int[]{r-1,c});
					}
					if (canGo(r+1,c,grid,visited,rows,cols)){
						visited[r+1][c]= visited[r][c]+1;
						queue.add(new int[]{r+1,c});
					}
				}
			}
		}
		if (visited[rows-1][cols-1]==0){
			visited[rows-1][cols-1]=-1;
		}
	}

}
