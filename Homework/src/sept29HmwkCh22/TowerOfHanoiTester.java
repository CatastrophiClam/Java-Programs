package sept29HmwkCh22;
import java.util.ArrayList;

public class TowerOfHanoiTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TowerOfHanoiNonRecLogic logic = new TowerOfHanoiNonRecLogic();
		ArrayList<int[]>answer = logic.solve(10);
		for (int i = answer.size()-1; i >= 0; i--){
			for (int j:answer.get(i)){
				System.out.print(j);
			}
			System.out.println();
		}
		
	}

}
