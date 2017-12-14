package stairsQuestion;
import java.util.Scanner;
/**
 * Stairs Challenge Question: You can go up a flight of stairs 1 at a time, 2 at a time, or 3 at a time.
 * Find the number of ways you can go up a flight of n stairs
 *
 */
public class StairsQuestionSolver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		StairsLogic logic = new StairsLogic();
		System.out.print("Enter number of stairs: ");
		int stairNum = scan.nextInt();
		int answer = logic.calculate(stairNum);
		System.out.print("The number of different ways you can go up the stairs is: "+answer);
	}

}
