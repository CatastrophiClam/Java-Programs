package dynamicProgramming;
import java.util.*;

public class MinimumEditDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter string 1: ");
		String s1 = scan.nextLine();
		System.out.println("Enter string 2: ");
		String s2 = scan.nextLine();
		
		System.out.println(findDist(s1,s2));
	}
	
	public static int findDist(String s1, String s2){
		int[][] table = new int[s1.length()+1][s2.length()+1];
		for (int i = 0; i < s1.length()+1; i++){
			table[i][0] = i;
		}
		for (int i = 0; i < s2.length()+1; i++){
			table[0][i] = i;
		}
		for (int i = 1; i < s1.length()+1; i++){
			for (int j = 1; j < s2.length()+1; j++){
				table[i][j] = min(table[i-1][j],table[i][j-1],table[i-1][j-1]);
				if (s1.charAt(i-1)!=s2.charAt(j-1)){
					table[i][j]++;
				}
			}
		}
		return table[s1.length()][s2.length()];
	}
	
	public static int min(int a, int b, int c){
		int min = a;
		if (b < a){
			min = b;
		}
		if (c < min){
			min = c;
		}
		return min;
	}

}
