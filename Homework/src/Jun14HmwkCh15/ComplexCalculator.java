package Jun14HmwkCh15;
import java.util.Scanner;
public class ComplexCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the first complex number: "); // prompt user for first complex number
		double comp1Real = scan.nextDouble();                 // read in values
		double comp1Imag = scan.nextDouble(); 
		Complex num1 = new Complex(comp1Real, comp1Imag); // make number
		System.out.print("Enter the second complex number: "); // repeat
		double comp2Real = scan.nextDouble(); 
		double comp2Imag = scan.nextDouble();
		Complex num2 = new Complex(comp2Real, comp2Imag);
		
	}

}
