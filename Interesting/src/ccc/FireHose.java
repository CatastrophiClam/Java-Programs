package ccc;
import java.io.*;
import java.util.Scanner;
import java.lang.Math;
import java.util.ArrayList;

public class FireHose {
	/**
	 * Algorithm is as follows: find the (numHydrants) biggest distances between 2 adjacent houses, and put a hydrant opposite their middle
	 * 
	 * 
	 */
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		File file = new File("Test.txt.txt");
		Scanner scan = new Scanner(file);
		int numHouses = scan.nextInt();
		int[] houses = new int[numHouses];
		for (int i = 0; i < numHouses; i++){
			houses[i] = scan.nextInt();
		}
		int numHydrants = scan.nextInt();
		ArrayList<Integer> biggestDistances = new ArrayList<Integer>();
		ArrayList<Integer> hydrantPositions = new ArrayList<Integer>();
	}
	
	public static int around(int start, int range){
		
	}

}
