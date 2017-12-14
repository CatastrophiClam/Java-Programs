package ccc;
import java.util.*;
import java.io.*;

public class s4_2013EvenBetter {
	
	static HashMap<Integer,ArrayList<Integer>> taller;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int numPeople = scan.nextInt();
		int numComparisons = scan.nextInt();
		int a, b, p, q;
		
		taller = new HashMap<Integer,ArrayList<Integer>>();
		for (int i = 0; i < numComparisons; i++){
			a = scan.nextInt();
			b = scan.nextInt();
			if (!taller.containsKey(a)){
				taller.put(a, new ArrayList<Integer>());
			}
			taller.get(a).add(b);
		}
		
		p = scan.nextInt();
		q = scan.nextInt();
		
		if (dfs(p,q)){
			System.out.println("yes");
		}else if(dfs(q,p)){
			System.out.println("no");
		}else{
			System.out.println("unknown");
		}
		
	}
	
	public static boolean dfs(int a, int b){
		if (!taller.containsKey(a)){
			return false;
		}
		ArrayList<Integer> smallers = taller.get(a);
		for (int i = 0; i < smallers.size();i++){
			if (smallers.get(i)==b){
				return true;
			}else{
				if (dfs(smallers.get(i),b)){
					return true;
				}
			}
		}
		return false;
	}

}
