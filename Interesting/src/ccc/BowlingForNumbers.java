package ccc;
import java.util.Scanner;
import java.util.ArrayList;

public class BowlingForNumbers {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int numPins = 10;
		int[] pinValues = new int[numPins];
		int numBalls = 3;
		int ballWidth = 3;
		int pinsLeft = numPins - numBalls*ballWidth;
		System.out.print(maxScore(pinValues, numBalls, ballWidth));
		
	}
	
	public static int maxScore(int[] pinValues, int numBalls, int ballWidth){
		
	}
	
	public static ArrayList<Integer>findLowest(int numLowest, int[] values){
		ArrayList<Integer> lowests = new ArrayList<Integer>();
		for (int i: values){
			
		}
	}
	
	public static void binaryInsert(int regex, ArrayList<Integer> array){
		int minIndex = 0;
		int maxIndex = array.size();
		boolean inserted = false;
		while (!inserted){
			if (array.get((minIndex + maxIndex)/2)>regex){
				array.add((minIndex+maxIndex)/2, regex);
			}
		}
	}
}
