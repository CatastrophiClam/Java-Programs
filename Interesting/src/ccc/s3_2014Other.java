package ccc;
import java.util.*;

public class s3_2014Other {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int numCases = scan.nextInt();
		for (int i =0; i < numCases; i++){
			eval(scan);
		}
	}
	
	public static void eval(Scanner scan){
		Stack<Integer> stack = new Stack<Integer>();
		Stack<Integer> branch = new Stack<Integer>();
		int numCars = scan.nextInt();
		branch.push(numCars+1);
		int current;
		int prevGo = 0;
		boolean c,t;
		for (int i = 0; i <numCars; i++){
			stack.push(scan.nextInt());
		}
		for (int i = 0; i < numCars; i++){
			current = stack.pop();
			c = false;
			t = false;
			while (true){
				if (current == prevGo+1){
					prevGo = current;
					c = true;
				}
				while (branch.peek() == prevGo+1){
					prevGo = branch.pop();
				}
			}
		}
	}

}
