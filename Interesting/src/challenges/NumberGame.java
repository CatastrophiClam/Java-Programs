package challenges;
import java.io.*;
import java.util.*;

public class NumberGame {
	
	//returns true if Stan wins
	static boolean predictWinner(long n){
		boolean winner = true;
		while (true){
			n = (n+8-(n-1)%9)/9; //find lowest number that when multiplied by 9 exceeds/equals n
			if (n==1){
				return winner;
			}
			winner = false;
			n = (n+1-(n-1)%2)/2;
			if (n==1){
				return winner;
			}
			winner = true;
		}
	}

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new FileReader("Files/In"));
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("Files/Out")));
		int numCases = Integer.parseInt(reader.readLine());
		long n;
		for (int i = 0; i < numCases; i++){
		n = Long.parseLong(reader.readLine());
			if (predictWinner(n)){
				System.out.println("Stan Wins");
			}else{
				System.out.println("Ollie Wins");
			}
		}
	}

}
