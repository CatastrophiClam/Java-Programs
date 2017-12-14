package usaco;

import java.util.ArrayList;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.print(convertBase(1000,16));
	}
	public static String convertBase(int num, int base){
		String key = "0123456789ABCDEFGHIJK";
		String answer = "";
		int temp;
		//find maximum power
		int maxPower = 0;
		for (;Math.pow(base, maxPower+1)<=num;maxPower++){
			
		}
		for (int i = maxPower; i >= 0; i--){
			temp = num/(int)Math.pow(base, i);
			num = num%(int)Math.pow(base,i);
			answer += String.valueOf(key.charAt(temp));
		}
		return answer;
	}

}
