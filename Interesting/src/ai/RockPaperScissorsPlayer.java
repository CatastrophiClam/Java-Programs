package ai;
import java.util.*;
import java.io.*;


public class RockPaperScissorsPlayer {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		RockPaperScissorsAIV2 ai = new RockPaperScissorsAIV2();
		int input;
		int wins = 0;
		int losses = 0;
		int ties = 0;
		int answer;
		String[] key = new String[]{"","Rock","Paper","Scissors"};
		Random rand = new Random();
		int times = 0;
		int maxTimes = 20000;
		
		while (times<maxTimes){
			times++;
			//System.out.println("1 - Rock,  2 - Paper,  3 - Scissors,  4 - Stats: ");
			input = rand.nextInt(3)+1;
			
			if (input == 4){
				System.out.println("Wins: "+wins+" Losses: "+losses+" Ties: "+ties+" Win Percentage: "+(wins/(wins+losses+ties+0.0)*100)+"%");
			}else if (input == 5){
				double[][] biases = ai.getBiases();
				for (int i = 0; i < biases.length; i++){
					System.out.print("[");
					for (int j = 0; j < biases[i].length; j++){
						System.out.printf("%.2f, ",biases[i][j]);
					}
					System.out.println("]");
				}
			}else{
				answer = ai.output();
				//answer = rand.nextInt(3)+1;
				//System.out.println(key[answer]);
				if (input-answer == 1 || input-answer == -2){
					//System.out.println("You win!");
					wins++;
				}else if(input - answer == 0){
					//System.out.println("Tie");
					ties++;
				}else{
					//System.out.println("You lose.");
					losses++;
				}
				ai.recordMove(input);
			}
		}
		System.out.println("Wins: "+wins+" Losses: "+losses+" Ties: "+ties+" Win Percentage: "+(wins/(wins+losses+ties+0.0)*100)+"%");
	}

}
