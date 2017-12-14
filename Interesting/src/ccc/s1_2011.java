package ccc;
import java.util.Scanner;
import java.io.*;
public class s1_2011 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		File file = new File("Test.txt.txt");
		Scanner reader = new Scanner(file);
		int numLines = reader.nextInt();
		int sC = 0;
		int tC = 0;
		String temp;
		for (int i = 0; i < numLines; i++){
			temp = reader.nextLine();
			for (int j = 0; j < temp.length(); j++){
				if (temp.charAt(j) == 's' || temp.charAt(j)=='S'){
					sC ++;
				}else if (temp.charAt(j) == 't' || temp.charAt(j) == 'T'){
					tC ++;
				}
			}
		}
		if (sC < tC){
			System.out.print("English");
		}else{
			System.out.print("French");
		}
	}

}
