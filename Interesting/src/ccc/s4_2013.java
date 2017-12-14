package ccc;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
public class s4_2013 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		File file = new File("Test.txt.txt");
		Scanner reader = new Scanner(file);
		int numPeople = reader.nextInt();
		int numCompared = reader.nextInt();
		int b;
		int s;
		ArrayList<ArrayList<Integer>> big = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < numPeople+1; i++){
			big.add(new ArrayList<Integer>());
		}
		for (int i = 0; i < numCompared; i++){
			b=reader.nextInt();
			s = reader.nextInt();
			big.get(b).add(s);
		}
		int p = reader.nextInt();
		int q = reader.nextInt();
		boolean bigger = search(p,q,big);
		boolean smaller = search(q,p,big);
		if (bigger){
			System.out.print("Yes");
		}else if(smaller){
			System.out.print("No");
		}else{
			System.out.print("Unknown");
		}
	}
	
	public static boolean search(int p, int q, ArrayList<ArrayList<Integer>> master){
		if (master.get(p).size() != 0){
			if (master.get(p).contains(q)){
				return true;
			}else{
				for (int i:master.get(p)){
					if (search(i,q,master)){
						return true;
					}
				}
				return false;
			}
		}
		return false;
	}

}
