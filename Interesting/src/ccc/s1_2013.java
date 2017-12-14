package ccc;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

public class s1_2013 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		File file = new File("test.txt.txt");
		Scanner reader = new Scanner(file);
		Scanner scanner = new Scanner(System.in);
		int year = scanner.nextInt();
		boolean checked = false;
		while (!check(String.valueOf(year))){
			year ++;
		}
		System.out.print(year);
	}
	
	public static boolean check(String s){
		ArrayList<String> a = new ArrayList<String>();
		for(int i = 0; i < s.length(); i++){
			if (a.contains(s.substring(i,i+1))){
				return false;
			}else{
				a.add(s.substring(i,i+1));
			}
		}
		return true;
	}

}
