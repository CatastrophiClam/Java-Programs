package jan18hmwk;

import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Math;
public class EightQueensLogic {
	ArrayList<int[]> coordList = new ArrayList<int[]>();  // list of queen positions
	boolean var;
	ArrayList<Integer> temp = new ArrayList<Integer>();
	boolean done = false;
	final int NUMQUEENS = 8;
	
	public ArrayList<int[]> queenPositions(){
		find(0);
		return coordList;
	}
	
	public void find(int i){   // i is the x - coordinate
		for (int j = 0; j <NUMQUEENS&&!done; j++){
				var = true;
				for (int[] k : coordList){  // if the queen at the current set of coords doesn't attack any other queen
					if (attacks(k, i, j)){
						var = false;
					}
				}
				if (var){                       // add that queen's coords to list
					coordList.add(new int[] {i,j});
					if (coordList.size() == NUMQUEENS){   // if we found a good position for all 8 queens
						done = true;
					}else{         // otherwise find a good position for the next queen
						find(i+1);
					}
				}
			}	
		if (!done){         // if still isn't done after trying every square, remove last coord from coordlist
			if (coordList.size()>0)
				coordList.remove(coordList.size()-1);
		}
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
