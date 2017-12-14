package stairsQuestion;
import java.util.Scanner;
public class StairsOtherWay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the number of stairs: ");
		int n = scan.nextInt();
		System.out.printf("The number of ways you can go up the stairs is: %d", findNum(n));
	}
	
	public static int findNum(int n){   // pattern is: T_n = T_n-1 + T_n-2 + T_n-3
		if (n == 1){
			return 1;
		}else if(n == 2){
			return 2;
		}else if(n == 3){
			return 4;
		}else{
			return findNum(n-1)+findNum(n-2)+findNum(n-3);
		}
	}

}
