package usaco;

/*
ID: Max
LANG: JAVA
TASK: pprime
*/

import java.util.*;
import java.lang.Math;
import java.io.*;

public class pprime {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new FileReader("pprime.in"));
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("pprime.out")));
		String[] buffer = reader.readLine().split(" ");
		HashMap<Integer,ArrayList<String>> map = new HashMap<Integer,ArrayList<String>>();
		HashMap<Integer,ArrayList<Integer>> primes = new HashMap<Integer,ArrayList<Integer>>();
		printPalindromes(Integer.parseInt(buffer[0]),Integer.parseInt(buffer[1]),writer,map, primes);
		reader.close();
		writer.close();
		System.exit(0);
	}
	
	public static void printPalindromes(int min, int max, PrintWriter writer, HashMap<Integer,ArrayList<String>> map, HashMap<Integer,ArrayList<Integer>> primes){
		String smin = String.valueOf(min);
		String smax = String.valueOf(max);
		getPalindromes(smax.length(),min,max,writer, map, primes);
		ArrayList<Integer> current;
		for (int i = smin.length(); i <= smax.length(); i++){
			current = primes.get(i);
			for (int j:current){
				if (j >= min){
					if (j <= max){
						writer.println(j);
					}else{
						return;
					}
				}
			}
		}
	}
	
	public static ArrayList<String> getPalindromes(int len, int min, int max, PrintWriter writer, HashMap<Integer,ArrayList<String>> map, HashMap<Integer,ArrayList<Integer>> primes){
		if (map.containsKey(len)){
			return map.get(len);
		}
		ArrayList<String> pals = new ArrayList<String>();
		ArrayList<Integer> primeNums = new ArrayList<Integer>();
		if (len == 1){
			for (int i = 0; i < 10; i++){
				pals.add(String.valueOf(i));
				if (i>=min && i <= max && isPrime(i)){
					primeNums.add(i);
				}
			}
			primes.put(len, primeNums);
			return pals;
		}else if (len == 2){
			for (int i = 0; i < 10; i++){
				pals.add(String.valueOf(i)+String.valueOf(i));
				if (i+i*10 >= min && isPrime(i+i*10)){
					if (i+i*10 <= max){
						primeNums.add(i+i*10);
					}else{
						primes.put(len, primeNums);
						return pals;
					}
				}
			}
			primes.put(len, primeNums);
			return pals;
		}else{
			getPalindromes(len-1,min,max,writer,map,primes);
			ArrayList<String> pastPals = getPalindromes(len -2, min, max, writer,map,primes);
			String temp;
			int tempInt;
			for (int i = 0; i <= 9; i++){
				for (String j:pastPals){
					if (i == 0){
						pals.add("0"+j+"0");
					}else{
						temp = String.valueOf(i)+j+String.valueOf(i);
						pals.add(temp);
						tempInt = Integer.parseInt(temp);
						if (tempInt >= min){
							if (tempInt <= max){
								if (isPrime(tempInt)){
									primeNums.add(tempInt);
								}
							}else{
								primes.put(len, primeNums);
								return pals;
							}
						}
					}
				}
			}
			primes.put(len, primeNums);
			return pals;
		}
	}
	
	public static boolean isPrime(int num){
		if (num == 0 || num == 1){
			return false;
		}
		if (num==2){
			return true;
		}
		for (int i = 2; i <= Math.round(Math.sqrt(num)); i++){
			if (num % i==0){
				return false;
			}
		}
		return true;
	}

}
