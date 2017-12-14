package ccc;
import java.util.*;
import java.lang.Math;
import java.io.*;

public class s5_2006 {
	static int size,rows,cols;
	static int a,b,c;
	static HashMap<Integer,ArrayList<Integer>> results = new HashMap<Integer,ArrayList<Integer>>();//maps a position to all the positions that can produce it
	static HashSet<Integer> visited = new HashSet<Integer>();
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(new File("Test.txt.txt"));
		String[] input = reader.nextLine().split(" ");
		rows = Integer.parseInt(input[0]);
		cols = Integer.parseInt(input[1]);
		a = Integer.parseInt(input[2]);
		b = Integer.parseInt(input[3]);
		c = Integer.parseInt(input[4]);
		
		//construct starting position
		String[][] in = new String[rows][cols];
		boolean[][] start = new boolean[rows][cols]; //true indicates live, false dead
		for (int i = 0; i < rows; i++){
			in[i] = reader.nextLine().split("");
			for (int j = 0; j < cols; j++){
				start[i][j]= in[i][j].equals("*");
			}
		}
		int startInt = toInt(start);
		
		size = (int)(Math.pow(2,rows*cols));
		//find all possible positions and find map them to their previous positions
		int temp;
		for (int i = 0; i < size; i++){
			temp = findNext(i);
			//System.out.println(i+": "+temp);
			if (results.containsKey(temp)){
				results.get(temp).add(i);
			}else{
				results.put(temp, new ArrayList<Integer>());
				results.get(temp).add(i);
			}
		}
		
		System.out.println(find(startInt));
		
		/**
		boolean[][] test = {{true,true,false,true,true},{false,false,true,false,true},{false,false,false,false,true},{true,true,true,true,true}};
		int testInt = toInt(test);
		start=toPosition(findNext(testInt));
		System.out.println(startInt);
		//System.out.println(findAlives(toPosition(1048574),0,0));
		///**
		//start = toPosition(1048574);
		for (int i = 0; i < rows; i++){
			for (int j = 0; j < cols; j++){
				System.out.print(start[i][j]+" ");
			}
			System.out.println();
		}
		**/
		
	}
	
	public static int find(int a){
		int count = 0;
		int tempCount = 0;;
		ArrayDeque<Integer>queue = new ArrayDeque<Integer>();
		queue.add(a);
		int current;
		for (int i = 0; i < 60 &&!queue.isEmpty(); i++){
			current = queue.remove();
			if (tempCount > 0){
				tempCount--;
			}
			if (!results.containsKey(current)){
				return count;
			}else{
				ArrayList<Integer> paths = results.get(a);
				for (int j:paths){
					if (!visited.contains(i)){
						visited.add(i);
						queue.add(j);
					}
				}
			}
			if (tempCount == 0){
				tempCount = queue.size();
				count++;
			}
		}
		return -1;
	}
	
	public static int findAlives(boolean[][]position,int row,int col){
		int t,b,r,l;
		int total = 0;
		t = row-1;
		b = row+1;
		if (row == 0){
			t = 0;
		}else if(row == rows-1){
			b = row;
		}
		
		l = col-1;
		r = col+1;
		if (col==0){
			l = col;
		}else if(col == cols-1){
			r = col;
		}
		
		for (int i = t; i <= b; i++){
			for (int j = l; j <= r; j++){
				if (position[i][j]){
					total++;
				}
			}
		}
		if (position[row][col]){
			total--;
		}
		return total;
	}
	
	//returns integer code for next generation of position with code a
	public static int findNext(int a){
		boolean[][] current = toPosition(a);
		boolean[][] next = new boolean[rows][cols];
		int alives;
		for (int i = 0; i < rows; i++){
			for (int j = 0; j < cols; j++){
				alives = findAlives(current,i,j);
				if (current[i][j]){
					next[i][j] = (alives >= a && alives <= b);
				}else{
					next[i][j] = alives > c;
				}
			}
		}
		return toInt(next);
	}
	
	public static boolean[][] toPosition(int a){
		boolean[][]answer = new boolean[rows][cols];
		for (int i = 0; i < rows*cols; i++){
			answer[i/cols][i%cols] = a%2==1;
			a/=2;
		}
		return answer;
	}
	
	public static int toInt(boolean[][]position){
		int total = 0;
		for (int i = 0; i < rows*cols; i++){
			if (position[i/cols][i%cols]){
				total += Math.pow(2,i);
			}
		}
		return total;
	}

}
