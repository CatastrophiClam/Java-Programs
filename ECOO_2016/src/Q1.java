import java.util.*;
import java.io.*;
public class Q1 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(new File("DATA11.txt"));
		int T, A, P, Q;
		int t,a,p,q;
		int N;
		double total;
		int totalPassed;
		for (int i = 0 ; i < 10; i++){
			totalPassed = 0;
			T = reader.nextInt();
			A = reader.nextInt();
			P = reader.nextInt();
			Q = reader.nextInt();
			N = reader.nextInt();
			for (int j = 0; j < N; j++){
				t = reader.nextInt();
				a = reader.nextInt();
				p = reader.nextInt();
				q = reader.nextInt();
				total = T*t/100.0+A*a/100.0+P*p/100.0+Q*q/100.0;
				if (total >= 50){
					totalPassed++;
				}
			}
			System.out.println(totalPassed);
		}
	}

}
