package ai;
import java.util.*;
import java.io.*;


public class RandomTester {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		RockPaperScissorsAIV2 ai = new RockPaperScissorsAIV2();
		int input;
		int wins = 0;
		int losses = 0;
		int ties = 0;
		int answer;
		
		int rwins = 0;
		int rlosses = 0;
		int rties = 0;
		int ranswer;
		
		Random rand = new Random();
		int times = 0;
		int maxTimes = 200000;
		
		while (times<maxTimes){
			times++;
			input = rand.nextInt(3)+1;
			answer = ai.output();
			ranswer = rand.nextInt(3)+1;
			if (input-answer == 1 || input-answer == -2){
					wins++;
			}else if(input - answer == 0){
				ties++;
			}else{
				losses++;
			}
			if (input-ranswer == 1 || input-ranswer == -2){
				rwins++;
			}else if(input - ranswer == 0){
				rties++;
			}else{
				rlosses++;
			}
			ai.recordMove(input);
			
		}
		System.out.println("AI Wins: "+wins+" Losses: "+losses+" Ties: "+ties+" Win Percentage: "+(wins/(wins+losses+ties+0.0)*100)+"%");
		System.out.println("R Wins: "+wins+" Losses: "+losses+" Ties: "+ties+" Win Percentage: "+(rwins/(rwins+rlosses+rties+0.0)*100)+"%");
	}

}
