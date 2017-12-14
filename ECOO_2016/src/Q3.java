import java.util.*;
import java.io.*;


public class Q3 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(new File("DATA31.txt"));
		for (int i = 0; i < 10; i++) { //make this 10
			int numCount = reader.nextInt();
			int[] carts = new int[numCount];
			int totalCost = 0;
			
			for (int j = 0; j < numCount; j++){
				carts[j]=reader.nextInt();
			}
			
			int position = findNextLargestElement(carts, numCount + 1, numCount);
			while (position != -1) {
				totalCost += position;
				int temp = carts[position];
				
				for (int j = position; j > 0; j--) {
					carts[j] = carts[j - 1];
				}
				
				carts[0] = temp;
				position = findNextLargestElement(carts, numCount + 1, numCount);				
			}
			
			System.out.println(totalCost);
		}
	}

	static int findNextLargestElement(int[] elements, int previousLargest, int largestPosition) {
		if (previousLargest == 1 && largestPosition == 0) {
			return -1;
		}
		
		for (int i = 0; i < elements.length; i++) {
			if (elements[i] == previousLargest - 1) {
				if (i > largestPosition) {
					return i;
				} else {
					return findNextLargestElement(elements, previousLargest - 1, i);
				}
			}
		}
		return -2;
	}

}
