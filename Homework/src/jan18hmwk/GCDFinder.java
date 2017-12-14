package jan18hmwk;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
public class GCDFinder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter 5 numbers: ");
		int int1 = scan.nextInt();
		int int2 = scan.nextInt();
		int int3 = scan.nextInt();
		int int4 = scan.nextInt();
		int int5 = scan.nextInt();
		System.out.print("The gcd of these numbers is: "+gcd(int1, int2, int3, int4, int5));
	}
	
	public static int gcd(int...numbers){
		boolean divisibleByAll;
		int gD = 1;
		for (int i = 1; i <=min(numbers); i++){   // try all nums from 1 - smallest number
			divisibleByAll = true;       // number is divisible by all until proved otherwise
			for (int j:numbers){        // try every number
				if (j%i != 0){
					divisibleByAll = false;
				}
			}
			if (divisibleByAll)
				gD = i;
		}
		return gD;
	}
	
	public static int min(int[]array){
		int minimum = array[0];
		for (int i : array){
			if (i < minimum){
				minimum = i;
			}
		}
		return minimum;
	}

}
