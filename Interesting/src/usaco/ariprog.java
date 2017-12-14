package usaco;

import java.io.*;
import java.util.*;

/*
ID: Max
LANG: JAVA
TASK: ariprog
*/

public class ariprog {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new FileReader("ariprog.in"));
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("ariprog.out")));
		//BufferedReader reader = new BufferedReader(new FileReader("Test.txt.txt"));
		//PrintStream writer = System.out;
		int progLen = Integer.parseInt(reader.readLine());
		int maxPQ = Integer.parseInt(reader.readLine());
		int maxBisquare = 2*maxPQ*maxPQ;
		
		ArrayList<Integer> biSquares = findBiSquares(maxPQ);
		ArrayList<Integer> difs = new ArrayList<Integer>();
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 1; i < biSquares.size(); i++){
			//difs.add(biSquares.get(i)-biSquares.get(i-1));
			set.add(biSquares.get(i));
		}
		
		boolean written = false;
		int start = 0;
		int total = 0;
		int len = 0;
		int ind;
		int currentDif = 0;
		for(int dif = 1; dif*(progLen-1)<= maxBisquare; dif++){ //try each difference size
			for(start = 0 ; biSquares.get(start)+dif*(progLen-1) <= biSquares.get(biSquares.size()-1) ;start++){
				total = 0;
				len = 1;
				while (true){
					if (set.contains(biSquares.get(start)+dif*(len))){
						len++;
					}else{
						break;
					}
				}
				//print good ones
				if (len >= progLen){
					writer.println(biSquares.get(start)+" "+dif);
					written = true;
				}
				/**
				for (ind = start; ind < difs.size(); ind++){
					total += difs.get(ind);
					currentDif = difs.get(ind);
					if (total == dif){
						len++;
						total = 0;
					}else if(total > dif){
						break;
					}
				}
				//print good ones
				if (len >= progLen){
					writer.println(biSquares.get(start)+" "+dif);
					written = true;
				}else{
					if (currentDif > dif){
						if (ind < difs.size()-1){
							start = ind;
						}
					}
				}
				**/
			}
		}
		if (!written){
			writer.println("NONE");
		}
		reader.close();
		writer.close();
		System.exit(0);
	}
	
	public static ArrayList<Integer> findBiSquares(int maxPQ){
		ArrayList<Integer> biSquares = new ArrayList<Integer>();
		biSquares.add(maxPQ*maxPQ*2);
		int startInd = 0;
		int num;
		 
		for (int i = maxPQ-1; i >= 0; i--){
			startInd = 0;
			int j = i;
			while (j <= maxPQ){
				num = i*i+j*j;
				if (num < biSquares.get(startInd)){
					biSquares.add(startInd,num);
					startInd++;
					j++;
				}else if (num > biSquares.get(startInd)){
					startInd++;
				}else{
					j++;
				}
			}
		}
		return biSquares;
	}

}
