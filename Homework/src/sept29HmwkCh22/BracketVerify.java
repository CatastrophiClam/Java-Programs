package sept29HmwkCh22;
import java.util.Scanner;

public class BracketVerify {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		BracketSortLogic logic = new BracketSortLogic();
		//System.out.print("Enter brackets: ");
		String brackets;
		//brackets = scan.nextLine();
		brackets = "([{()()[{}]}])";
		System.out.print(logic.verify(brackets));
	}

}
