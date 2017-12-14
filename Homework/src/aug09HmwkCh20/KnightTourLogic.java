package aug09HmwkCh20;

import java.util.ArrayList;

public class KnightTourLogic {
	ArrayList<int[]> path = new ArrayList<int[]>();
	int squaresFound = 1;
	int x;
	int y;
	public KnightTourLogic(){
		
	}
	
	public ArrayList<int[]> getPath(int startX, int startY){
		x = startX;
		y = startY;
		path.add(new int[]{x, y});
		find();
		return path;
	}
	
	/**
	 * Logic is as follows: move knight to the square where it has the least places to go to
	 */
	public void find(){
		ArrayList<int[]> possibleCoords = getPossibleSquares(x, y);
		int[] toGoCoords = new int[2];
		int minSquares = 8;
		for (int[]i : possibleCoords){
			if (numOptions(i[0], i[1]) <= minSquares){
				minSquares = numOptions(i[0], i[1]);
				toGoCoords = i;
			}
		}
		path.add(toGoCoords);
		x = toGoCoords[0];
		y = toGoCoords[1];
		squaresFound++;
		if (squaresFound < 64){
			find();
		}
	}
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @return Number of possible squares to go to from x,y
	 */
	public int numOptions(int x, int y){
		int totalOptions = 0;
		if (checkBounds(x+2, y+1)){
			totalOptions ++;
		}
		if (checkBounds(x+2, y-1)){
			totalOptions ++;
		}
		if (checkBounds(x-2, y+1)){
			totalOptions ++;
		}
		if (checkBounds(x-2, y-1)){
			totalOptions ++;
		}
		if (checkBounds(x+1, y+2)){
			totalOptions ++;
		}
		if (checkBounds(x-1, y+2)){
			totalOptions ++;
		}
		if (checkBounds(x+1, y-2)){
			totalOptions ++;
		}
		if (checkBounds(x-1, y-2)){
			totalOptions ++;
		}
		return totalOptions;
	}
	
	/**
	 * returns all possible squares knight can move to
	 */
	public ArrayList<int[]> getPossibleSquares(int x, int y){
		ArrayList<int[]> coordList = new ArrayList<int[]>();
		if (checkBounds(x+2, y+1)){
			if (!isIn(x+2, y+1, path))
			coordList.add(new int[]{x+2, y+1});
		}
		if (checkBounds(x+2, y-1)){
			if (!isIn(x+2, y-1, path))
			coordList.add(new int[]{x+2, y-1});
		}
		if (checkBounds(x-2, y+1)){
			if (!isIn(x-2, y+1, path))
			coordList.add(new int[]{x-2, y+1});
		}
		if (checkBounds(x-2, y-1)){
			if (!isIn(x-2, y-1, path))
			coordList.add(new int[]{x-2, y-1});
		}
		if (checkBounds(x+1, y+2)){
			if (!isIn(x+1, y+2, path))
			coordList.add(new int[]{x+1, y+2});
		}
		if (checkBounds(x-1, y+2)){
			if (!isIn(x-1, y+2, path))
			coordList.add(new int[]{x-1, y+2});
		}
		if (checkBounds(x+1, y-2)){
			if (!isIn(x+1, y-2, path))
			coordList.add(new int[]{x+1, y-2});
		}
		if (checkBounds(x-1, y-2)){
			if (!isIn(x-1, y-2, path))
			coordList.add(new int[]{x-1, y-2});
		}
		return coordList;
	}
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @param array 
	 * @return is the point specified by x and y in array?
	 */
	public boolean isIn(int x, int y, ArrayList<int[]> array){
		for (int[]i : array){
			if (x == i[0] && y == i[1]){
				return true;
			}
		}
		return false;
	}
	
	public boolean checkBounds(int x, int y){
		return (x >= 0 && x <= 7 && y >= 0 && y <= 7);
	}
}
