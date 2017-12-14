package March1HmwkCh8;
import java.util.Scanner;
public class FindLocation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number of rows and columns in the array, respectively: ");
		int numRows = scan.nextInt();
		int numCols = scan.nextInt();
		double[][]array = new double[numCols][numRows];
		for (int i = 0; i < numRows; i++){
			for (int j = 0; j < numCols; j++){
				array[i][j] = scan.nextDouble();
			}
		}
		Location loc = locateLargest(array);
		System.out.printf("The location of the largest element, %f, is at (%d, %d)", loc.maxValue, loc.row, loc.column);
	}
	
	public static Location locateLargest(double[][]array){
		return new Location(array);
	}

}


