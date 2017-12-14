package March1HmwkCh8;
import java.util.Scanner;
public class IntersectionFinder {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		double x1;
		double x2;
		double x3;
		double x4;
		double y1;
		double y2;
		double y3;
		double y4;
		System.out.println("Enter endpoints of first line segment: ");
		x1 = scan.nextDouble();
		y1 = scan.nextDouble();
		x2 = scan.nextDouble();
		y2 = scan.nextDouble();
		System.out.println("Enter endpoints of second line segment: ");
		x3 = scan.nextDouble();
		y3 = scan.nextDouble();
		x4 = scan.nextDouble();
		y4 = scan.nextDouble();
		double[] equ1 = makeEquation(x1, y1, x2, y2);
		double[] equ2 = makeEquation(x3, y3, x4, y4);
		LinearEquationSolver solver = new LinearEquationSolver(equ1[0], equ1[1], equ2[0], equ2[1], equ1[2], equ2[2]);
		System.out.printf("The intersecting point is: (%f, %f)", solver.getX(), solver.getY());
	}
	/**
	 * returns int[] containing variables a, b, c of the equation ax + by = c
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @return
	 */
	public static double[] makeEquation(double x1, double y1, double x2, double y2){
		double slope = (y2-y1)/(x2 - x1);
		double yInt = y1 - slope*x1;
		return new double[]{slope, -1, 0-yInt};
	}

}
