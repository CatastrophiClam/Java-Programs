package quadraticsAndLinearEqus;
import java.util.Scanner;
public class EvalTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Evaluate ev = new Evaluate();
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter equation: ");
		String equ = scan.nextLine();
		double answer = ev.eval(equ);//"(1+(2*4+2)*2)/3+(1+(2*4+2)*2)/3+(1+(2*4+2)*2)/3+(1+(2*4+2)*2)/3+(1+(2*4+2)*2)/3");
		System.out.print(answer); 
	}

}
