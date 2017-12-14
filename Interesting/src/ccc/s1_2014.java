package ccc;
import java.util.*;

public class s1_2014 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int numPeople = scan.nextInt();
		int numRounds = scan.nextInt();
		int[] mults = new int[numRounds];
		for (int i = 0; i < numRounds;i++){
			mults[i]=scan.nextInt();
		}
		
		ArrayList<Integer> friends = new ArrayList<Integer>();
		for (int i = 1; i <= numPeople; i++){
			friends.add(i);
		}
		
		for (int i = 0; i < numRounds; i++){
			for (int j = mults[i], k = 0; j <= friends.size()+k; j+=mults[i],k++){
				friends.remove(j-1-k);
			}
		}
		for (int i:friends){
			System.out.println(i);
		}
	}

}
