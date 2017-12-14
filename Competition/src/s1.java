import java.io.*;
import java.util.Scanner;
import java.util.Stack;
public class s1 {
	
	/**
	 * Logic as follows: push all numbers read to stack(except 0)
	 * if 0 is read, pop a number
	 * after finishing reading, sum everything still in the stack
	 */
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		File file = new File("s1.in");       //input file
		Scanner reader = new Scanner(file);  //reader for file
		Stack<Integer> stack = new Stack<Integer>();           //stack to store all the numbers we read
		int numNumbers = reader.nextInt();   // number of numbers we'll read
		int currentNumber;          // current number we're reading
		
		//read all numbers
		for (int i = 0; i < numNumbers; i++){
			currentNumber = reader.nextInt();
			if (currentNumber == 0){
				stack.pop();
			}else{
				stack.push(currentNumber);
			}
		}
		
		int total = 0; // the sum we return
		
		//sum everything left in the stack
		while (!stack.empty()){
			total += stack.pop();
		}
		
		System.out.print(total);
	}

}
