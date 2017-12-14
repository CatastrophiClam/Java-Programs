package quadraticsAndLinearEqus;
import java.util.Scanner;

public class SimultaneousEquationSolver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		SimultaneousEquationLogic logic = new SimultaneousEquationLogic();
		System.out.println("Enter number of variables: ");  // prompt for number of variables
		int numVar = scan.nextInt();          // init number of variables
		int[][] equList = new int[numVar][numVar];  // array storing all equations
		for(int i = 0; i < numVar; i++){
			System.out.printf("Enter equation %d", i);  
			equList[i] = logic.equForm(scan.nextLine());  // add equations to list
		}
	}

}
