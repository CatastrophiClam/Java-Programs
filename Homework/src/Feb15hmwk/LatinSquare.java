package Feb15hmwk;
import java.util.Scanner;
public class LatinSquare {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter number n: ");
		int n = scan.nextInt();
		String[][] square = new String[n][n];
		String[] tempArray = new String[n];
		System.out.printf("Enter %d rows of %d letters separated by spaces: ", n, n);
		for (int i = 0; i< n; i++){     // init square
			for (int j = 0; j < n; j ++){
				square [i][j] = scan.next();
			}
		}
		for (String[]i : square){   // check every row
			if (!checkComplete(i)){
				System.out.println("This is not a Latin Square");
				return;
			}
		}
		for (int i = 0; i < n; i++){
			for (int j = 0; j < n; j++){
				tempArray[j] = square[j][i];
			}
			if (!checkComplete(tempArray)){
				System.out.println("This is not a Latin Square");
				return;
			}
		}
		System.out.print("This is a Latin Square");
	}
	
	public static boolean checkComplete(String[]letters){
		String[] alpha = new String[]{"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
		for (int i = 0; i < letters.length; i++){
			if (!contains(letters, alpha[i]))
				return false;
		}
		return true;
	}
	
	public static boolean contains(String[] array, String val){
		for (String i : array){
			if (i.equals(val))
				return true;
		}
		return false;
	}

}
