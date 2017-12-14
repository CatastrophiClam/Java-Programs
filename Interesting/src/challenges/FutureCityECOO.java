package challenges;

import java.io.*;
import java.util.*;
public class FutureCityECOO {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(new File("Test.txt.txt"));
		String[] buffer = new String[10];
		buffer = reader.nextLine().split(" ");
		int r = Integer.parseInt(buffer[0]);
		int c = Integer.parseInt(buffer[1]);
		int[][] map = new int[r][c];
		buffer = reader.nextLine().split(" ");
		int SR = Integer.parseInt(buffer[0]);
		int SC = Integer.parseInt(buffer[1]);
		buffer = reader.nextLine().split(" ");
		int FR = Integer.parseInt(buffer[0]);
		int FC = Integer.parseInt(buffer[1]);
		int numTPs = Integer.parseInt(reader.nextLine());
		int[][] key = new int[numTPs][2];
		
		int R,C,r1,c1;
		for (int i = 0; i < numTPs; i++){
			buffer = reader.nextLine().split(" ");
			R = Integer.parseInt(buffer[0]);
			C = Integer.parseInt(buffer[1]);
			r1 = Integer.parseInt(buffer[2]);
			c1 = Integer.parseInt(buffer[3]);
			map[R][C] = 0-i*2;
			key[i*2]= new int[] {r1,c1};
			map[r1][c1] = -1-i*2;
			key[i*2+1]= new int[]{R,C};
		}
		ArrayDeque<int[]> queue = new ArrayDeque<int[]>();
		queue.add(new int[] {SR,SC});
		
		int count = 0;
		int size;
		int[] process;
		while(true){
			size = queue.size();
			for (int i = 0; i < size; i++){
				process = queue.remove();
				map[process[0]][process[1]]=count;
			}
		}
	}

}
