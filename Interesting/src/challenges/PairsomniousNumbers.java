package challenges;

import java.io.*;
import java.util.*;

public class PairsomniousNumbers {
	
	private static ArrayList<Integer>array = new ArrayList<Integer>(); //array of all given sums
	private static ArrayList<Integer> key = new ArrayList<Integer>();  //value of each number
	private static int n;
	
	//finds and tries a value of A
	//first two terms are a+b and a+c
	//all possible values of bc are the smallest values in Array from 1 to n+1 inclusive (0-n for indexes)
	public static boolean findAVal(){
		int temp;
		int ab = array.get(0);
		int ac = array.get(1);
		array.remove(0);
		array.remove(1);
		for (int i = 0; i < n-2; i++){
			key.add(ab+ac-array.get(i)); //guess a
			key.add(ab-key.get(0)); //b based on a
			key.add(ac-key.get(0)); //c based on a
			if (key.size()<n){
				if (findAllVals()){
					return true;
				}
			}else{
				if (checkValidKey()){
					return true;
				}
			}
			key.clear();
		}
		return false;
		
	}
	
	public static boolean checkValidKey(){
		for (int i = 0; i < key.size();i++){
			for (int j = i; j < key.size(); j++){
				if (!array.contains(key.get(i)+key.get(j))){
					return false;
				}else{
					array.remove((Integer)(key.get(i)+key.get(j)));
				}
			}
		}
		return true;
	}
	
	//uses value from findAVal and uses it to try to find every other value
	public static boolean findAllVals(){
		int temp;
		for (int i = 0; i < array.size();i++){
			temp = array.get(i);
			array.remove(i);
			key.add(temp-key.get(0));
			if (key.size()==n){
				if (checkValidKey()){
					return true;
				}
			}else{
				findAllVals();
			}
			array.add(i,temp);
		}
		return false;
	}
	
	public static void binaryInsert(int a){
		int low = 0;
		int high = array.size();
		int ind;
		if (high == 0){
			array.add(a);
			return;
		}else if(high == 1){
			if (a > array.get(0)){
				array.add(1,a);
			}else{
				array.add(0,a);
			}
		}else{
			//binary insert
			while (true){
				ind = (low+high)/2;
				if (ind == 0){
					if (a > array.get(0)){
						array.add(1,a);
					}else{
						array.add(0,a);
					}
					return;
				}else if(ind == array.size()-1){
					if (a > array.get(array.size()-1)){
						array.add(array.size(),a);
					}else{
						array.add(array.size()-1,a);
					}
					return;
				}else if (array.get(ind-1)<= a && array.get(ind)>=a){
					array.add(ind,a);
					return;
				}else if (array.get(ind) <= a){
					low = ind;
				}else{
					high = ind;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new FileReader("Files/In"));
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("Files/Out")));
		n = Integer.parseInt(reader.readLine());
		for (int i = 0; i < n*(n-1)/2; i++){
			binaryInsert(Integer.parseInt(reader.readLine()));
		}
		if (findAVal()){
			for(int i = 0; i < key.size();i++){
				System.out.println(key.get(i));
			}
		}else{
			System.out.println("NO");
		}
		
	}

}
