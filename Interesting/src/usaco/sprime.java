package usaco;

import java.util.*;
import java.io.*;

/*
ID: Max
LANG: JAVA
TASK: sprime
*/

public class sprime {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new FileReader("sprime.in"));
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("sprime.out")));
		int N = Integer.parseInt(reader.readLine());
		findSuperPrimes(N,writer, true);
		reader.close();
		writer.close();
		System.exit(0);
	}
	
	public static ArrayList<Integer> findSuperPrimes(int N, PrintWriter writer, boolean write){
		ArrayList<Integer> primes = new ArrayList<Integer>();
		if (N == 1){
			primes.add(2);
			primes.add(3);
			primes.add(5);
			primes.add(7);
			if (write)
				for (int i = 0; i < 4; i++){
					writer.println(primes.get(i));
				}
		}else{
			ArrayList<Integer> pastPrimes = findSuperPrimes(N-1,writer,false);
			String temp;
			int tempInt;
			for (int i : pastPrimes){
				temp = String.valueOf(i);
				for (int j = 1; j <= 9; j+= 2){
					if (j!= 5){
						tempInt = Integer.parseInt(temp+String.valueOf(j));
						if (isPrime(tempInt)){
							if (write)
								writer.println(tempInt);
							primes.add(tempInt);
						}
					}
				}
			}
		}
		return primes;
	}
	
	public static boolean isPrime(int num){
		for (int i = 2; i <= Math.round(Math.sqrt(num)); i++){
			if (num % i==0){
				return false;
			}
		}
		return true;
	}

}
