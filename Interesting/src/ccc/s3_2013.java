package ccc;

import java.util.*;

public class s3_2013 {
	
	static int[][]matches;
	static int[] scores;
	static int team;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//File file = new File("Test.txt.txt");
		Scanner reader = new Scanner(System.in);
		team = reader.nextInt();
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
				scores[i]+=1;
				numWays += tryScore(scores[team]+1);
				scores[i]+=2;
				numWays+= tryScore(scores[team]);
				scores[i]-=3;
			}
		}
	}
	
	public static int tryScore(int maxScore){
		int tempScore = 1;
		int multiplier = 0;
		for (int i = 1; i < 5; i++){
			multiplier = 0;
			if (i==team){
				continue;
			}
			for (int j = 4; j>i;j--){
				if(matches[i][j]==0){
					if (scores[i]+3<maxScore && scores[j]+0<maxScore){
						multiplier++;
					}
					if (scores[i]+1<maxScore && scores[j]+1<maxScore){
						multiplier++;
					}
					if (scores[i]+0<maxScore && scores[j]+3<maxScore){
						multiplier++;
					}
				}
			}
			tempScore*=multiplier;
		}
		return tempScore;
	}

}




