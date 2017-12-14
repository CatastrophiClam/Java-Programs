//package ccc;

import java.util.*;

public class Main {
	
	static int[][]matches;
	static int[] scores;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//File file = new File("Test.txt.txt");
		Scanner reader = new Scanner(System.in);
		int team = reader.nextInt();
		int gamesPlayed = reader.nextInt();
		matches = new int[5][5]; //1-win,2-lose,3-tie
		scores = new int[5];
		int numWays = 0;
		int tempNumWays = 1;
		int a,b,sA,sB;
		
		for (int i = 0; i < gamesPlayed; i++){
			a = reader.nextInt();
			b = reader.nextInt();
			sA = reader.nextInt();
			sB = reader.nextInt();
			
			if (sA > sB){
				matches[a][b] = 1;
				scores[a]+=3;
			}else if (sB > sA){
				matches[a][b] = 2;
				scores[b] += 3;
			}else{
				matches[a][b] = 3;
				scores[a]+=1;
				scores[b]+=1;
			}
		}
		
		for (int i = 1; i < 5; i++){
			tempNumWays = 1;
			if (matches[team][i]==0){
				numWays+=tryScore(scores[team]+3);
				numWays += tryScore(scores[team]+1);
				numWays+= tryScore(scores[team]);
			}
		}
	}
	
	public static int tryScore(int maxScore){
		
	}

}




