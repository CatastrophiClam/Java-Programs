package sept29HmwkCh22;
import java.util.ArrayList;

public class TowerOfHanoiNonRecLogic {
	ArrayList<int[]> steps = new ArrayList<int[]>(); // position 0 of steps is first move
	ArrayList<int[]> finalSteps = new ArrayList<int[]>(); // return; position 0 is LAST move
	int numDisks;
	
	public TowerOfHanoiNonRecLogic(){
		
	}
	
	/**
	 * 
	 * @param n: total number of disks
	 * @return total number of moves required
	 * LOGIC AS FOLLOWS: every second move required to move n disks (to where the nth disk is at pole 3 and the rest are in a stack),
	 * combined, is the moves required for n-1 disks (to the same). 
	 * The rest of the moves are in a pattern: 1-3/1-2, 3-2/2-3, 2-1/3-1, 1-3/1-2, for odd n/even n, respectively
	 */
	public ArrayList<int[]> solve(int n){
		numDisks = n;
		for (int i = 1; i <= n; i++){
			construct(i, steps);
			// if n - i is odd, convert moves and add into finalSteps
			if ((n-i)%2 != 0){
				// steps from steps are taken FROM THE BACK and APPENDED to finalSteps
				for (int j = steps.size()-1; j >=0; j--){
					finalSteps.add(convert(steps.get(j)));
				}
				// if n-1 is even, don't convert
			}else{
				for (int j = steps.size()-1; j >=0; j--){
					finalSteps.add(steps.get(j));
				}
			}
		}
		return finalSteps;
	}
	
	/**
	 * 
	 * @param n The number of disks
	 * @param steps The steps to *partially solving a tower of hanoi with n-1 disks
	 * Partially solves a tower of hanoi with n disks
	 */
	public void construct(int n, ArrayList<int[]> steps){
		int a;
		int b;
		int[] oddList = new int[]{0, 3, 1, 2};
		int[] evenList = new int[]{0, 2, 3, 1};
		//if n is odd, add 1 - 3 to the front
		if (n % 2 != 0){
			a = 1;
			b = 3;
			steps.add(0, new int[]{1, 3});
			// add extra stuff at every second step
			for (int i = 2; i <= steps.size()-1; i += 2){
				a = oddList[a];
				b = oddList[b];
				steps.add(i, new int[]{a,b});
			}
			// similar if n is even
		}else{
			a = 1;
			b = 2;
			steps.add(0, new int[]{1, 2});
			// add extra stuff at every second step
			for (int i = 2; i <= steps.size()-1; i += 2){
				a = evenList[a];
				b = evenList[b];
				steps.add(i, new int[]{a,b});
			}
		}
	}
	
	public int[] convert(int[] regex){
		int[] numArray = new int[]{0, 2, 1, 3};
		return new int[]{numArray[regex[0]], numArray[regex[1]]};
	}
}
