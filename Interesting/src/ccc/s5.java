package ccc;
import java.util.*;
import java.io.*;
import java.lang.Math;

public class s5 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(new File("Test.txt.txt"));
		int numRows = reader.nextInt();
		int numCols = reader.nextInt();
		int withWireless = reader.nextInt();
		
		int[][] rates = new int[numRows+1][numCols+1];
		int col,row,radius,rate;
		int top,bot,left,right,sideDist; //inclusive
		for (int i = 0; i < withWireless; i++){
			col = reader.nextInt();
			row = reader.nextInt();
			radius = reader.nextInt();
			rate = reader.nextInt();
			
			top = row-radius;
			if (top < 1){
				top = 1;
			}
			
			bot = row + radius;
			if (bot > numRows){
				bot = numRows;
			}
			
			for (int j = top; j <= bot; j++){
				sideDist = (int)(Math.sqrt(radius*radius-(j-row)*(j-row)));
				left = col-sideDist;
				if (left < 1){
					left = 1;
				}
				right = col+sideDist+1;
				if (right > numCols){
					right = left;
				}
				rates[j][left]+=rate;
				if (right != left){
					rates[j][right]-= rate;
				}
			}
		}
		int maxRate = 0;
		int numShops = 0;
		for (int i = 1; i <= numRows; i++){
			for (int j = 1; j <= numCols; j++){
				rates[i][j]=rates[i][j]+rates[i][j-1];
				if (rates[i][j]> maxRate){
					numShops = 1;
					maxRate = rates[i][j];
				}else if(rates[i][j]==maxRate){
					numShops++;
				}
			}
		}
		System.out.println(maxRate);
		System.out.println(numShops);
	}

}
