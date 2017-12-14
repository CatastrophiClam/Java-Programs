package random;
import java.util.*;
import java.lang.Math;

public class Patterns {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int maxInt = 1000000;
		boolean printDifs = false;
		boolean printRatios = true;
		int sampleSize = 500;
		
		ArrayList<Integer> primes = getPrimes(0,maxInt);
		ArrayList<Integer> difs = new ArrayList<Integer>();
		HashMap<Integer,ArrayList<Integer>> differences = new HashMap<Integer,ArrayList<Integer>>();
		HashMap<Integer,Integer> lastSpots = new HashMap<Integer,Integer>();
		ArrayList<Integer> allDifs = new ArrayList<Integer>();
		int c;
		for (int i = 1; i < primes.size(); i++){
			c=primes.get(i)-primes.get(i-1);
			allDifs.add(c);
			if (differences.containsKey(c)){
				differences.get(c).add(i-lastSpots.get(c));
				lastSpots.replace(c, i);
			}else{
				difs.add(c);
				lastSpots.put(c, i);
				differences.put(c,new ArrayList<Integer>());
			}
		}
		if (printDifs){
			for (int i = 0; i < difs.size(); i++){
				System.out.println(difs.get(i)+": "+differences.get(difs.get(i)));
			}
		}
		int sum = 0;
		if (printRatios){
			for (int i = 0; i+sampleSize<allDifs.size(); i+=sampleSize){
				sum = 0;
				for (int j = i; j < i+sampleSize; j++){
					sum +=allDifs.get(j);
				}
				for (int k =0;k<sampleSize/50;k++)
					System.out.println(sum+" ");
			}
		}
	}
	
	public static ArrayList<Integer> getPrimes(int start, int end){
		ArrayList<Integer> primes = new ArrayList<Integer>();
		if (start %2==0){
			if (start==2){
				primes.add(2);
			}
			start++;
		}
		outer:
		for (int i = start; i <= end; i+=2){
			for (int j = 2; j < Math.sqrt(i)+1; j++){
				if (i%j==0){
					continue outer;
				}
			}
			primes.add(i);
		}
		return primes;
	}
}
