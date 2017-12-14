package ccc;
import java.util.*;
import java.io.*;

public class BouncingBall {
	static int width,height;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(new File("Test.txt.txt"));
		width = reader.nextInt();
		height = reader.nextInt();
		int onBottom = reader.nextInt();
		int onRight = reader.nextInt();
		
		ArrayList<HashSet<Integer>> visited = new ArrayList<HashSet<Integer>>();
		for (int i = 0; i < 4; i++){
			visited.add(new HashSet<Integer>());
		}
		
		visited.get(0).add(onBottom);
		visited.get(1).add(onRight);
		
		int[]temp;
		int pastSide = 0;
		int currentSide = 1;
		int a = onBottom;
		int b = onRight;
		boolean impossible = false;
		int bounces = 1;
		while(true){
			temp = nextPoint(a,b,pastSide,currentSide);
			if (visited.get(temp[1]).contains(temp[0])){
				impossible = true;
				break;
			}else{
				//if ball goes in a pocket
				if (temp[0]<5 || ( (temp[1]==0||temp[1]==2)&&width-temp[0]<5) || ( (temp[1]==1||temp[1]==3)&&height-temp[0]<5)){
					break;
				}else{
					bounces++;
					a = b;
					b = temp[0];
					pastSide = currentSide;
					currentSide = temp[1];
				}
			}
		}
	}
	
	/**
	 * 
	 * @param a
	 * @param b distance of ball on fromside and toSide
	 * @param fromSide
	 * @param toSide 0 indicates bottom, 1 indicates right, 2 indicates top, 3 indicates left side
	 * returns int[] with [0] being position on side and [1] being the side
	 */
	public static int[] nextPoint(int a, int b, int fromSide, int toSide){
		int nextSide;
		int position;
	}

}





