package ccc;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class s2_2013 {
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		File file = new File("Test.txt.txt");
		Scanner reader = new Scanner(file);
		int maxW = reader.nextInt();
		int numC = reader.nextInt();
		int totalW = 0;
		int totalC = 0;
		int temp;
		ArrayList<Integer> q = new ArrayList<Integer>();
		for (int i = 0; i < numC; i ++){
			if (i > 3){
				temp = reader.nextInt();
				maxW += temp;
				maxW -= q.get(0);
				q.remove(0);
				q.add(temp);
				if (totalW <= maxW){
					totalC ++;
					q.add(temp);
				}else{
					totalC ++;
					break;
				}
			}else{
				temp = reader.nextInt();
				totalW += temp;
				if (totalW <= maxW){
					totalC ++;
					q.add(temp);
				}else{
					totalC ++;
					break;
				}
			}
		}
		System.out.print(totalC);
	}
}
