package March1HmwkCh8;
import java.util.Scanner;
public class QuadraticSolver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Make sure quadratic is in form ax^2 + bx + c = 0");
		System.out.print("Enter a: ");
		double a = scan.nextInt();
		System.out.print("Enter b: ");
		double b = scan.nextInt();
		System.out.print("Enter c: ");
		double c = scan.nextInt();
		QuadraticEquation equ = new QuadraticEquation(a, b, c);
		System.out.printf("The roots of this equation are: %f and %f.", equ.getRoot1(), equ.getRoot2());
	}

}
