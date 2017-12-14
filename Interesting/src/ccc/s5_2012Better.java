package ccc;
import java.io.*;
import java.util.Scanner;
import java.util.Stack;
import java.util.ArrayList;
public class s5_2012Better {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		File file = new File("Test.txt.txt");
		Scanner reader = new Scanner(file);
		int R = reader.nextInt();
		int C = reader.nextInt();
		int numCats = reader.nextInt();
		int[]cX = new int[numCats];
		int[]cY = new int[numCats];
		for (int i = 0; i < numCats;i++){
			cY[i] = reader.nextInt();
			cX[i] = reader.nextInt();
		}
		long ways = 0;
		long[][]all = new long[C][R];
		for (long[]i:all){
			for (int j = 0; j < i.length;j++){
				i[j] = -1;
			}
		}
		System.out.print(findValue(new int[]{1,1}, all,cX,cY));
	}
	
	public static long findValue(int[] coord, long[][]all,int[]cX,int[]cY){
		long total =0;
		if (all[coord[0]-1][coord[1]-1]!= -1){
			return all[coord[0]-1][coord[1]-1];
		}else{
			if (coord[0]+1<=all.length){
				if (!(contains(cX,coord[0]+1)&&contains(cY,coord[1]))){
					if (coord[0]+1==all.length&&coord[1]==all[0].length){
						total += 1;
					}else{
						total += findValue(new int[]{coord[0]+1,coord[1]},all,cX,cY);
					}
				}
			}
			if (coord[1]+1<=all[0].length){
				if (!(contains(cX,coord[0])&&contains(cY,coord[1]+1))){
					if (coord[0]==all.length&&coord[1]+1==all[0].length){
						total += 1;
					}else{
						total += findValue(new int[]{coord[0],coord[1]+1},all,cX,cY);
					}
				}
			}
		}
		all[coord[0]-1][coord[1]-1] = total;
		return total;
	}
	
	public static boolean contains(int[]a,int b){
		for (int i : a){
			if (i==b){
				return true;
			}
		}
		return false;
	}

}
