package may17HmwkCh11;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class matrixFill {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		Random random = new Random();
		System.out.print("Enter size of matrix: ");
		int matrixSize = scan.nextInt();  // size of matrix
		int[][] rowMatrix = new int [matrixSize][matrixSize]; // arrays are rows of matrix
		int[][] colMatrix = new int [matrixSize][matrixSize]; // arrays are columns of matrix
		int temp; // temp value
		for (int i = 0; i < matrixSize; i++){     // generate matrices
			for (int j = 0; j < matrixSize; j++){
				temp = random.nextInt(2);
				rowMatrix[i][j] = temp;
				colMatrix[j][i] = temp;
			}
		}
		System.out.println("The randomly generated matrix is: ");
		for (int i = 0; i < matrixSize; i++){      // print matrix
			for (int j = 0; j < matrixSize; j++){
				System.out.print(rowMatrix[i][j]);
			}
			System.out.println();
		}
		System.out.print("The largest row index is: ");  // print indices
		for (int i: findLargestArrayIndex(rowMatrix)){
			System.out.print(i+ " ");
		}
		System.out.print("The largest column index is: ");
		for (int j: findLargestArrayIndex(colMatrix)){
			System.out.print(j+ " ");
		}
	}
	
	public static ArrayList<Integer> findLargestArrayIndex(int[][] bigArray){  // find index of numerically largest array
		ArrayList<Integer> largestIndex = new ArrayList<Integer>();
		int largestSum = 0;
		for (int i = 0; i < bigArray.length; i++){
			if (sum(bigArray[i]) > largestSum){    // if current sum is bigger than largest sum:
				largestIndex.clear();    // clear list
				largestIndex.add(i);     // add current index
				largestSum = sum(bigArray[i]);   // update largestSum
			}else if(sum(bigArray[i]) == largestSum){  // if current sum is equal:
				largestIndex.add(i);                  // add current index
			} 
		}
		return largestIndex;
	}
	
	public static int sum(int[] toSum){ // sum all elements of array
		int total = 0;
		for (int i:toSum){
			total += i;
		}
		return total;
	}

}
