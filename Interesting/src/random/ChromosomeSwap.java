package random;
import java.util.*;
import java.io.*;

public class ChromosomeSwap {
	static char[]p1;
	static char[]p2;
	static char[]child;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(new File("Test.txt.txt"));
		for (int c = 0; c < 10; c++){
			p1 = scan.nextLine().toCharArray();
			p2 = scan.nextLine().toCharArray();
			child = scan.nextLine().toCharArray();
			
			int[] key = new int[p1.length];
			for (int i = 0; i < p1.length; i++){
				if (child[i]==p1[i]){
					if (child[i]==p2[i]){
						key[i]=3;
					}else{
						key[i]=1;
					}
				}else if(child[i]==p2[i]){
					key[i]=2;
				}else{
					key[i]=0;
				}
			}
		}
	}

}
