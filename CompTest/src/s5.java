import java.io.*;
import java.util.*;
import java.lang.Math;

public class s5 {
	static int numRows,numCols, k;
	static int[][] bitRates; // bitrates are represented as actual bitRate [n][m] = bitRates[n][m-1]+bitRates[n][m] 

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);//new File("In"));
		numRows = reader.nextInt();
		numCols = reader.nextInt();
		k = reader.nextInt();
		bitRates = new int[numRows+1][numCols+1]; //don't use 0th space
		
		int row,col,radius,rate,xDif;
		int leftX,rightX;
		int rowI;
		for (int i = 0; i < k; i++){
			//for every coffee shop with a wireless station
			col = reader.nextInt();
			row = reader.nextInt();
			radius = reader.nextInt();
			rate = reader.nextInt();
			
			rowI = row-radius;
			if (rowI < 1){
				rowI = 1;
			}
			for(; (rowI <= row+radius) && (rowI <= numRows); rowI++){
				//for each row in range of the station
				xDif = (int)(Math.sqrt(radius*radius-(rowI-row)*(rowI-row))); //find farthest column where the signal is effective
				leftX = col-xDif;
				if (leftX < 1){
					leftX = 1;
				}
				rightX = col+xDif+1;
				if (rightX > numCols){ 
					//we don't want to change anything
					rightX = leftX;
				}
				
				//change bitRate range
				bitRates[rowI][leftX]+=rate;
				if (leftX!=rightX){
					bitRates[rowI][rightX]-=rate;
				}
			}
		}
		//find maximum bitRates
		int maxRate = 0;
		int numShops = 0;
		for (int i = 1; i <= numRows; i++){
			for (int j = 1; j <= numCols; j++){
				bitRates[i][j] = bitRates[i][j]+bitRates[i][j-1];
				
				if (bitRates[i][j]>maxRate){
					maxRate=bitRates[i][j];
					numShops = 1;
				}else if(bitRates[i][j]==maxRate){
					numShops++;
				}
			}
		}
		System.out.println(maxRate);
		System.out.println(numShops);
	}

}





