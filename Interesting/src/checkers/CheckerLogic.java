package checkers;
import java.util.ArrayList;
import java.lang.Math;

public class CheckerLogic {
	ArrayList<int[]> enemyCoords = new ArrayList<int[]>();
	ArrayList<Boolean> isEnemyQueen = new ArrayList<Boolean>();  // is the checker at the corresponding index a queen?
	ArrayList<int[]> selfCoords = new ArrayList<int[]>();
	ArrayList<Boolean> isSelfQueen = new ArrayList<Boolean>();  // is the checker at the corresponding index a queen?
	ArrayList<int[]> path = new ArrayList<int[]>();  // path to take
	int bestValue;   // value that determines how good a path is
	int currentValue; // value of current path
	final int NUM_ITERATIONS = 15;  // number of steps to look ahead
	
	public CheckerLogic(){
		// add all coordinates of own checkers
		for (int y = 0; y < 3; y++){         
			for (int x = 0 + y%2; x <= 7; x += 2){
				selfCoords.add(new int[]{x,y});
				isSelfQueen.add(false);
			}
		}
		// add all coordinates of enemy checkers
		for (int y = 7; y > 4; y--){
			for (int x = 0 + y%2; x <= 7; x += 2){
				enemyCoords.add(new int[]{x,y});
				isEnemyQueen.add(false);
			}
		}
	}
	
	/**
	 * 
	 * @param startX
	 * @param startY
	 * @param x
	 * @param y
	 * @return NOTE first int[] in path is location of the self checker that moves
	 * NOTE this method must be called whether or not it's self's turn to move or not
	 */
	public ArrayList<int[]> enemyMove(int startX, int startY, int x, int y, boolean selfMove){
		//update coord lists
		int enemyIndex = findIndex(enemyCoords, new int[]{startX, startY});  // index of coords of where enemy was
		enemyCoords.remove(enemyIndex);   //remove outdated coord
		boolean isQueen = isEnemyQueen.get(enemyIndex);  // keep track of whether or not it was a queen
		isEnemyQueen.remove(enemyIndex);  // remove queen boolean
		enemyCoords.add(new int[]{x, y});  // append new index
		isEnemyQueen.add(isQueen);         //append new queen boolean
		// see if enemy piece killed anything
		checkDead(startX, startY, x, y, selfCoords, isSelfQueen, 0);
		// if it's self's move, make a decision
		if (selfMove){
			findPath();
		}
		return path;
	}
	
	/**
	 * edit path by calling getPath on every self checker
	 * 
	 */
	public void findPath(){
		bestValue = -10;
		path.clear();
		for (int[] i: selfCoords){
			getPath(i, 0);
		}
	}
	
	/**
	 * find every possible move starting with moving the checker at startCoords
	 * @param startCoords
	 * @param numIterations
	 */
	public void getPath(int[] startCoords, int numIterations){
		
	}
	
	/**
	 * 
	 * @param list
	 * @param regex
	 * @return: find the index of regex in list
	 */
	public int findIndex(ArrayList<int[]> list, int[] regex){
		for (int i = 0; i < list.size(); i++){
			// if regex is found in list, return its index
			if (list.get(i)[0] == regex[0] && list.get(i)[1] == regex[1]){
				return i;
			}
		}
		return -1;
	}
	
	/**
	 * Checks to see whether a piece traveling from (startX, startY) to (x,y) captures any pieces FROM LIST
	 * If yes, remove corresponding pieces
	 * @param list 
	 * @param startX
	 * @param startY
	 * @param x
	 * @param y
	 * @param deathCounter: value of -1 and 1 means to adjust currentValue for a self death or an enemy death, respectively
	 *                      value of 0 means do not adjust currentValue
	 */
	public void checkDead(int startX, int startY, int x, int y, ArrayList<int[]> list, ArrayList<Boolean> isQueens, int deathCounter){
		if (Math.abs(startX-x)==2 && Math.abs(startY-y) == 2){  // if the moved piece skipped a square, remove what was on that square
			int removeIndex = findIndex(list, new int[]{(startX+x)/2, (startY+y)/2});
			list.remove(removeIndex);
			isQueens.remove(removeIndex);
			currentValue += deathCounter;
		}
	}
}
