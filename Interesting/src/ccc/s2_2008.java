package ccc;
import java.io.*;
import java.util.*;
import java.lang.Math;

public class s2_2008 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);//new File("Test.txt.txt"));
		int n = scan.nextInt();
		while (n!=0){
			calc(n);
			n = scan.nextInt();
		}
	}
	
	public static void calc(int n){
		int total = 0;
		for (int i = n; i > 0; i--){
			total+= (int)(Math.sqrt(n*n-i*i))*2+1;
		}
		total*=2;
		total += 2*n+1;
		System.out.println(total);
	}

}
