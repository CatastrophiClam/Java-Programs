package challenges;
import java.lang.Math;

public class EightQueensIterativeLogic {
	int n;             //number of queens
	
	public EightQueensIterativeLogic(int num){
		n = num;
	}
	
	public void setN(int n){
		this.n = n;
	}
	
	public int find(int start, int[] pos){
		int[] position = new int[n];
		for (int i = start; i < Math.pow(n, n);i++){
			for (int j = 0; j < n; j++){
				position[j]=(i/(int)(Math.pow(n,j)))%n;
				if (isGood(position)){
					for (int k = 0; k < n; k++){
						pos[k]=position[k];
					}
					return i;
				}
			}
		}
		return -1;
	}
	
	public boolean isGood(int[] position){
		for (int i = 1; i < n; i++){
			for (int j = i-1; j >=0; j--){
				if (attacks(new int[]{i,position[i]},j,position[j])){
					return false;
				}
			}
		}
		return true;
	}
	
	/** does the queen at b,c attack the queen at a?
	 * 
	 * @param a coordinate of one queen
	 * @param b x coord of other queen
	 * @param c y coord of other queen
	 * @return
	 */
	public boolean attacks(int[]a, int b, int c){
		if (a[0]==(b)){       // same x coord - same column
			return true;
		}else if (a[1]==(c)){  // same y coord - same row
			return true;
		}else if (Math.abs((c - a[1])*1.0/(b - a[0])) == 1.0){  // slope is 1 - same diagonal
			return true;
		}else{
			return false;
		}
	}
}
