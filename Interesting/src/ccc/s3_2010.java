package ccc;
import java.io.*;
import java.util.Scanner;

public class s3_2010 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		File file = new File("Test.txt.txt");
		Scanner reader = new Scanner(file);
		int numHouses = Integer.parseInt(reader.nextLine());
		int[] houses = new int[numHouses];
		for (int i = 0; i < numHouses; i++){
			houses[i] = Integer.parseInt(reader.nextLine());
		}
		int numHydrants = reader.nextInt();
		
	}

}
