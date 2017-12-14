package aug09HmwkCh20;
import java.util.ArrayList;

public class KnightTourTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KnightTourLogic logic = new KnightTourLogic();
		ArrayList<int[]> path = logic.getPath(7, 7);
		for (int[]i:path){
			for (int j:i){
				System.out.print(j);
				System.out.print(",");
			}
			System.out.println();
		}
	}

}
