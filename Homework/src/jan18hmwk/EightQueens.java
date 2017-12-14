package jan18hmwk;
import java.util.ArrayList;
public class EightQueens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<int[]> coords = new ArrayList<int[]>();
		EightQueensLogic EQ = new EightQueensLogic();
		coords = EQ.queenPositions();
		boolean var;
		for (int i = 7; i>=0; i--){       //print board
			System.out.print("|");
			for (int j = 0; j<=7; j++){    // i is y - coord, j is x  -coord
				var = true;
				for (int[] k:coords){    // if there is a queen at current coords, place queen
					if (k[0]==j&&k[1]==i){
						var = false;
					}
				}
				if (var)
					System.out.print(" |");
				else
					System.out.print("Q|");
			}
			System.out.println();
		}
	}

}
