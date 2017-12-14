package Feb15hmwk;
import java.util.Scanner;
public class LargestSquareMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the number of rows in the matrix: ");
		int numRows = scan.nextInt();
		int[][] matrix = new int[numRows][numRows];
		System.out.println("Enter the matrix row by row: ");
		for (int i = 0; i < numRows; i++){
			for (int j = 0; j < numRows; j++){
				matrix [i][j] = scan.nextInt();
			}
		}
		int[] results = findLargestBlock(matrix, numRows);
		System.out.printf("The largest square matrix is at (%d, %d) with size %d", results[0], results[1], results[2]);
	}
	
	public static int[] findLargestBlock(int[][]matrix, int numRows){
		int[]result = new int[]{0,0,1};
		boolean isSub;
		for (int i = 2; i < numRows; i ++){   // size of submatrix
			for (int j = 0; j < numRows - i; j ++){    // coords of top left corner of each possible square
				for (int k = 0; k < numRows - i; k++){
					isSub = true;
					for (int l = 0; l < i; l++){     // check the square
						for (int m = 0; m < i; m++){
							if (matrix[j+l][k+m] != matrix[j][k]){  // if an element in the square doesn't equal the top left element, the square is not a submatrix
								isSub = false;
							}
						}
					}
					if (isSub){  // if square is submatrix, record its coords and size
						result[0] = j;
						result[1] = k;
						result [2] = i;
					}
				}
			}
		}
		return result;
	}

}
