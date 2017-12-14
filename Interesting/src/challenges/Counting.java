package challenges;
import java.util.*;
import java.lang.Math;

public class Counting {
	static int sum = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter n: ");
		int n = scan.nextInt();
		int[] nums = new int[3];
		nums[0] = n;
	}
	
	public static void sum(int[]arr){
		sum += (int)Math.pow(2, arr[0])*(factorial(arr[0]+arr[1]+arr[2])/factorial(arr[0])/factorial(arr[1])/factorial(arr[2]));
	}
	
	public static int factorial(int a){
		int total = 0;
		for (int i = a; i > 0; i--){
			total += i;
		}
		return total;
	}

}
