package Jun14HmwkCh15;
import java.util.Scanner;
public class EvalTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		eval Evaluate = new eval();
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter equation: ");
		String equ = scan.nextLine();
		String answer = Evaluate.evaluate(equ);
		System.out.println(answer);
	}

}
