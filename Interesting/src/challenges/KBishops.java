package challenges;
import java.util.*;

public class KBishops {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the size of the board n: ");
		int n = scan.nextInt();
		System.out.println("Enter the number of bishops k: ");
		int k = scan.nextInt();
		if (k > 2*n-2){
			System.out.println("0");
			return;
		}
		boolean[][] board = new boolean[n][n];
		
	}

}
