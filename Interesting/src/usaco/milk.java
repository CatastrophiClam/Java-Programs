package usaco;

import java.io.*;
import java.util.*;

/*
ID: Max
LANG: JAVA
TASK: milk
*/

public class milk {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new FileReader("milk.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk.out")));
		String[] input;
		input = reader.readLine().split(" ");
		int milkGoal = Integer.parseInt(input[0]);
		int numFarmers = Integer.parseInt(input[1]);
		HashMap<Integer,Integer> milk = new HashMap<Integer,Integer>();
		ArrayList<Integer> prices = new ArrayList<Integer>();
		
		int price, amount, temp;
		for (int i = 0; i < numFarmers; i++){
			input = reader.readLine().split(" ");
			price = Integer.parseInt(input[0]);
			amount = Integer.parseInt(input[1]);
			if (milk.containsKey(price)){
				temp = milk.get(price);
				milk.remove(price);
				milk.put(price, temp+amount);
			}else{
				prices.add(findInsertPos(price,prices),price);
				milk.put(price,amount);
			}
		}
		//prices.sort(null);
		int currentPrice;
		long totalPrice = 0;
		for (int i = 0; i < prices.size(); i++){
			currentPrice = prices.get(i);
			if (milkGoal > milk.get(currentPrice)){
				totalPrice += currentPrice*milk.get(currentPrice);
				milkGoal -= milk.get(currentPrice);
			}else{
				totalPrice += milkGoal*currentPrice;
				break;
			}
		}
		out.println(totalPrice);
		out.close();
		reader.close();
		System.exit(0);
	}
	
	public static int findInsertPos(int a, ArrayList<Integer> list){
		int min = 0;
		int max = list.size();
		int findIndex;
		while (true){
			if (max==0){
				return 0;
			}else if(max == 1){
				if (a >= list.get(0)){
					return 1;
				}else{
					return 0;
				}
			}else{
				findIndex = (min+max)/2;
				if (findIndex == 0){
					if (a <= list.get(0)){
						return 0;
					}else{
						min = 1;
					}
				}else if (findIndex == list.size()-1){
					if (list.get(findIndex)>=a){
						if (list.get(findIndex-1)<=a){
							return findIndex;
						}else{
							max = findIndex-1;
						}
					}else{
						return findIndex+1;
					}
				}else if (list.get(findIndex-1)<=a){
					if (list.get(findIndex)>=a){
						return findIndex;
					}else{
						min = findIndex;
					}
				}else{
					max = findIndex;
				}
			}
		}
	}

}
