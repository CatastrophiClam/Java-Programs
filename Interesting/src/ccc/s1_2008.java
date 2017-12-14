package ccc;
import java.io.*;
import java.util.*;
public class s1_2008 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(new File("Test.txt.txt"));
		int minTemp = 1000000;
		String theCity = "";
		String[] input;
		while(true){
			input = reader.nextLine().split(" ");
			if (Integer.parseInt(input[1])<minTemp){
				minTemp = Integer.parseInt(input[1]);
				theCity = input[0];
			}
			if (input[0].equals("Waterloo")){
				break;
			}
		}
		System.out.println(theCity);
	}

}
