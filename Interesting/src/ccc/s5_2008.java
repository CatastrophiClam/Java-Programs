package ccc;
import java.util.*;
import java.io.*;


public class s5_2008 {
	static int[][][][] wins; //1 = lose, 2 = win

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(new File("Test.txt.txt"));
		int numCases = reader.nextInt();
		wins = new int[30][30][30][30];
		int a,b,c,d;
		for (int i = 0; i < numCases; i++){
			a = reader.nextInt();
			b = reader.nextInt();
			c = reader.nextInt();
			d = reader.nextInt();
			if (isWin(a,b,c,d)){
				System.out.println("Patrick");
			}else{
				System.out.println("Roland");
			}
		}
		
	}
	
	public static boolean check(int a, int b, int c, int d){
		return a>=0 && b>= 0 && c>= 0 && d>= 0;
	}
	
	public static boolean isWin(int a, int b, int c, int d){
		if (wins[a][b][c][d]==1){
			return false;
		}else if(wins[a][b][c][d]==2){
			return true;
		}
		boolean win = false;
		if (check(a-2,b-1,c,d-2)){
			if (!isWin(a-2,b-1,c,d-2)){
				win = true;
			}
		}
		
		if (!win&&check(a-1,b-1,c-1,d-1)){
			if (!isWin(a-1,b-1,c-1,d-1)){
				win = true;
			}
		}
		
		if (!win&&check(a,b,c-2,d-1)){
			if (!isWin(a,b,c-2,d-1)){
				win = true;
			}
		}
		
		if (!win&&check(a,b-3,c,d)){
			if (!isWin(a,b-3,c,d)){
				win = true;
			}
		}
		
		if (!win&&check(a-1,b,c,d-1)){
			if (!isWin(a-1,b,c,d-1)){
				win = true;
			}
		}
		if (win){
			wins[a][b][c][d]=2;
		}else{
			wins[a][b][c][d]=1;
		}
		return win;
	}

}





