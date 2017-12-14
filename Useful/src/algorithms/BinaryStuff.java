package algorithms;
import java.lang.Math;
import java.util.*;

public class BinaryStuff {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean[] a = {true,false,true,true,false,true,false,false,false};
		int num = toInt(a);
		System.out.println(num);
		a = toBinary(num,9);
		for (int i = 0; i < 9; i++){
			System.out.print(a[i]+" ");
		}
		System.out.println();
		num = toInt(a);
		System.out.println(num);
	}
	
	public static boolean[] toBinary(int a, int length){
		//gives leftmost place least value;
		boolean[] answer = new boolean[length];
		for (int i = 0; i < length; i++){
			answer[i]=(a%2==1);
			a/=2;
		}
		return answer;
	}
	
	public static int toInt(boolean[] a){
		//leftmost place holds the least value
		int total = 0;
		for (int i = 0; i < a.length; i++){
			if (a[i]){
				total+=Math.pow(2, i);
			}
		}
		return total;
	}

}
