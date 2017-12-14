package ccc;
import java.util.Scanner;
import java.io.*;
public class s2_2011 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		File file = new File("Test.txt.txt");
		Scanner scan = new Scanner(file);
		int N = Integer.parseInt(scan.nextLine());
		int C = 0;
		String temp;
		String[] a = new String[N];
		for (int i = 0; i < N; i++){
			a[i] = scan.nextLine();
		}
		for (int i = 0; i < N; i++){
			temp = scan.nextLine();
			if (temp.equals(a[i])){
				C++;
			}
		}
		System.out.print(C);
	}

}
