package Tests;
import java.util.ArrayList;
import java.util.Collections;
import java.lang.Math;
import dataStructures.*;

public class test1 {
	public static void main(String[]args){
		
	}
	
	public static int min(int a, int b){
		if (a<b) return a;
		return b;
	}
	
	public static int find(int goal, int from){
		if (goal == 0){
			return 1;
		}
		int total = 0;
		for (int i = min(from,goal); i > 0; i--){
				if (i*(i+1)/2>=goal){
					total += find(goal-i, i-1);
				}else{
					break;
				}
			
		}
		return total;
	}
	
	public static String toString(int a){
		String answer = "";
		while (a != 0){
			answer = a%2 + answer;
			a = a/2;
		}
		return answer;
	}
	
	public static boolean[] process(int[] actions, int len){
		boolean[] answer = new boolean[len];
		for (int i:actions){
			switch(i){
			case 1:
				for (int j = 0; j < len; j++){
					answer[j]=!answer[j];
				}
				break;
			case 2:
				for (int j = 0; j < len; j+=2){
					answer[j] = !answer[j];
				}
				break;
			case 3:
				for (int j = 1; j < len; j+=2){
					answer[j] = !answer[j];
				}
				break;
			case 4:
				for (int j = 0; j < len; j+=3){
					answer[j]=!answer[j];
				}
				break;
			}
		}
		return answer;
	}
	
	
	public static ArrayList<ArrayList<Integer>> getCombs(int size){
		ArrayList<ArrayList<Integer>> all = new ArrayList<ArrayList<Integer>>();
		all.add(new ArrayList<Integer>());
		if (size == 1){
			all.get(0).add(1);
		}else{
			all.get(0).add(size);
			ArrayList<ArrayList<Integer>> temp = getCombs(size-1);
			for (ArrayList<Integer> i:temp){
				all.add(new ArrayList<Integer>(i));
				i.add(size);
				all.add(i);
			}
		}
		return all;
	}
}
