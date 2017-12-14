
import java.util.*;
import java.io.*;
import java.lang.Math;

public class s1 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(new File("In"));
		long a = reader.nextLong();
		long b = reader.nextLong();
		int start = (int)(Math.sqrt(a))-1;
		long num;
		double temp;
		int count = 0;
		while (true){
			num = start*start;
			if (num > b){
				break;
			}
			if (num < a){
				start++;
				continue;
			}
			if (Math.pow(num, 1/3)==(int)(Math.pow(num,1/3))){
				System.out.println(num);
				count++;
			}
			start++;
		}
		System.out.println(count);
	}

}
