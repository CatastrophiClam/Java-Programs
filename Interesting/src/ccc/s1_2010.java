package ccc;
import java.io.*;
import java.util.Scanner;

public class s1_2010 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		File file = new File("test.txt.txt");
		Scanner reader = new Scanner(file);
		int numLines = reader.nextInt();
		String name1 = "";
		int score1 = 0;
		String name2 = "";
		int score2 = -1;
		String[] temp;
		int tempScore;
		for (int i = 0; i < numLines; i++){
			temp = reader.nextLine().split(" ");
			tempScore = Integer.parseInt(temp[1])+3*Integer.parseInt(temp[2])+Integer.parseInt(temp[3]);
			if (tempScore > score1){
				score1 = tempScore;
				name1 = temp[1];
			}else if (tempScore > score2){
				score2 = tempScore;
				name2 = temp[1];
			}
		}
		System.out.println(name1);
		if (score2 != -1){
			System.out.println(name2);
		}
	}

}
