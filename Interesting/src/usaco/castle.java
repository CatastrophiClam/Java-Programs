package usaco;

import java.io.*;
import java.util.*;

/*
ID: Max
LANG: JAVA
TASK: castle
*/
public class castle {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new FileReader("castle.in"));
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("castle.out")));
		//BufferedReader reader = new BufferedReader(new FileReader("Test.txt.txt"));
		//PrintStream writer = System.out;
		String[] buffer = new String[50];
		buffer = reader.readLine().split(" ");
		int numCols = Integer.parseInt(buffer[0]);
		int numRows = Integer.parseInt(buffer[1]);
		int[][] floor = new int[numRows][numCols];
		HashMap<Integer,Integer> rooms = new HashMap<Integer,Integer>();
		HashMap<Integer,ArrayList<int[]>> roomLocs = new HashMap<Integer,ArrayList<int[]>>();
		
		int temp;
		boolean top,bot,right,left; //is there a wall there?
		int key = 1;
		int currentKey;
		int otherKey = -1;
		int maxSize = 1;
		
		for (int i = 0; i < numRows; i++){
			buffer = reader.readLine().split(" ");
			for (int j = 0; j < numCols; j++){
				temp = Integer.parseInt(buffer[j]);
				currentKey = -1;
				
				bot = temp >= 8;
				if(temp >= 8){
					temp -= 8;
				}
				right = temp >= 4;
				if(temp >= 4){
					temp -= 4;
				}
				top = temp >= 2;
				if(temp >= 2){
					temp -= 2;
				}
				left = temp >= 1;
				
				if ((top||floor[i-1][j]==0)&&(left||floor[i][j-1]==0)){
					floor[i][j]=key;
					rooms.put(key, 1);
					roomLocs.put(key, new ArrayList<int[]>());
					roomLocs.get(key).add(new int[]{i,j});
					key++;
				}else{ //only need to check top and left
					if(!top){
						currentKey = floor[i-1][j];
						floor[i][j]=currentKey;
						rooms.put(currentKey, rooms.remove(currentKey)+1);
						roomLocs.get(currentKey).add(new int[]{i,j});
					}
					if(!left){
						if (currentKey == -1){
							currentKey = floor[i][j-1];
							floor[i][j]=currentKey;
							rooms.put(currentKey, rooms.remove(currentKey)+1);
							roomLocs.get(currentKey).add(new int[]{i,j});
						}else{
							otherKey = floor[i][j-1];
							if (currentKey != otherKey){
								rooms.put(currentKey,rooms.remove(currentKey)+rooms.get(otherKey));
								for (int[]k:roomLocs.get(otherKey)){
									floor[k[0]][k[1]]=currentKey;
								}
								roomLocs.get(currentKey).addAll(roomLocs.remove(otherKey));
								rooms.remove(otherKey);
							}
						}
					}
					if (rooms.get(currentKey)>maxSize){
						maxSize = rooms.get(currentKey);
					}
				}
			}
		}
		writer.println(rooms.size());
		writer.println(maxSize);
		int wallX,wallY;
		wallX = -1;
		wallY = -1;
		char wallDir = '0';
		int maxCombSize = 0;
		int tempSize;
		
		for (int j = 0; j < numCols; j++){
			for (int i = numRows-1; i >= 0;i --){
				currentKey = floor[i][j];
				if (i!= 0){
					otherKey = floor[i-1][j];
					if(currentKey!=otherKey){
						tempSize = rooms.get(currentKey)+rooms.get(otherKey);
						if (tempSize > maxCombSize){
							maxCombSize = tempSize;
							wallX = i+1;
							wallY = j+1;
							wallDir = 'N';
						}
					}
				}
				if (j != numCols-1){
					otherKey = floor[i][j+1];
					if(currentKey!=otherKey){
						tempSize = rooms.get(currentKey)+rooms.get(otherKey);
						if (tempSize > maxCombSize){
							maxCombSize = tempSize;
							wallX = i+1;
							wallY = j+1;
							wallDir = 'E';
						}
					}
				}
			}
		}
		writer.println(maxCombSize);
		writer.println(wallX + " "+ wallY+ " "+wallDir);
		writer.close();
		reader.close();
		System.exit(0);
	}

}
