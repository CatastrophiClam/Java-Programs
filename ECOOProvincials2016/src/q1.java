import java.util.*;
import java.io.*;
public class q1 {

	static final int NUM_ROLLS = 10;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(new File("DATA11.txt"));
		for (int i = 0; i < NUM_ROLLS; i++) {
			double numDice = reader.nextInt();
			double numSides = reader.nextInt();
			int count = 0;
			while(numDice >= numSides){
				numDice -= numDice/numSides;
				count++;
			}
			while(numDice > 0){
				count += numSides/numDice;
				numDice--;
			}
			System.out.println(count);
		}
		
	}
	
}
