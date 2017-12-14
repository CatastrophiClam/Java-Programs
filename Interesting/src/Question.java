import java.util.*;
public class Question {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String temp;
		String other;
		int a = 3;
		int b = 2;
		long c,d;
		long i = 1;
		Scanner reader = new Scanner(System.in);
		long j = reader.nextLong();
		while(i < j){
			c = a*i;
			d = b*i;
			if (isSwitch(d,c)){
				System.out.println(c+" "+d);
			}
			i++;
		}
	}
	
	public static boolean isSwitch(long a, long b){
		String s1 = String.valueOf(a);
		String s2 = String.valueOf(b);
		if (s1.substring(1, s1.length()).equals(s2.substring(0, s2.length()-1))&&s1.charAt(0)==s2.charAt(s2.length()-1)){
			return true;
		}
		return false;
	}

}
