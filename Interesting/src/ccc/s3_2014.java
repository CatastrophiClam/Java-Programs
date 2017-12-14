package ccc;
import java.util.*;
public class s3_2014 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int numCases = scan.nextInt();
		for (int i =0; i < numCases; i++){
			eval(scan);
		}
	}
	
	public static void eval(Scanner scan){
		int numCars = scan.nextInt();
		int lastGo = scan.nextInt();
		int lastBranch = numCars+1;
		int current;
		for (int i = 1; i < numCars; i++){
			current = scan.nextInt();
			if (current > lastGo){
				if (current > lastBranch){
					System.out.println("N");
					return;
				}else{
					lastBranch = current;
				}
			}else{
				lastGo = current;
			}
		}
		System.out.println("Y");
	}

}
