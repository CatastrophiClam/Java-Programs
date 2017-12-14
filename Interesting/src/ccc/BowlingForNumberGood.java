package ccc;
import java.io.*;
import java.util.*;

public class BowlingForNumberGood {
	static int numPins,numBalls,ballWidths;
	static int[] pins;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(new File("Test.txt.txt"));
		numPins = reader.nextInt();
		numBalls = reader.nextInt();
		ballWidths = reader.nextInt();
		pins = new int[numPins];
		for (int i = 0; i < numPins; i++){
			pins[i] = reader.nextInt();
		}
		
	}

}
