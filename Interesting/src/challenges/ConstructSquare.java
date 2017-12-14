package challenges;

import java.util.*;

public class ConstructSquare {
	
	//static ArrayList<int[]> squares = new ArrayList<int[]>();
	//static ArrayList<int[]> temp = new ArrayList<int[]>();
	//static int minLen;
	static int n;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		//minLen = n*n+1;
		ArrayList<int[]>squares = construct(n,n,0,0);
		for (int[]i:squares){
			System.out.printf("%d %d %d \n",i[0],i[1],i[2]);
		}
		scan.close();
	}
	
	
	/**
	 * finds the fewest amount of squares to fill the box with height h and lenght len
	 * @param minNum fewest squares so far
	 * @param h
	 * @param len
	 * @param tlX coords of top-left corner
	 * @param tlY
	 * @return
	 */
	public static ArrayList<int[]> construct(int h, int len, int tlX, int tlY){
		int maxLen;
		int minSize = 100000;
		ArrayList<int[]> squares = new ArrayList<int[]>();
		ArrayList<int[]> temp = new ArrayList<int[]>();
		
		if (h<len){
			maxLen = h;
		}else{
			maxLen = len;
		}
		if (maxLen == n){
			maxLen--;
		}
		
		
		for (int i = maxLen; i >= 1; i--){
			temp.add(new int[]{tlX,tlY,i});
			temp.addAll(construct(i,len-i,tlX+i,tlY));
			temp.addAll(construct(h-i,len,tlX,tlY+i));
			if (temp.size()<minSize){
				squares.clear();
				squares.addAll(temp);
				minSize = squares.size();
			}
			temp.clear();
		}
		return squares;
	}

}
