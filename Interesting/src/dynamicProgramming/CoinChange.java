package dynamicProgramming;
import java.util.*;

public class CoinChange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter number of coins: ");
		int numCoins = scan.nextInt();
		
		int[] coins = new int[numCoins];
		System.out.println("Enter coins: ");
		for (int i = 0; i < numCoins; i++){
			coins[i]=scan.nextInt();
		}
		
		System.out.println("Enter total: ");
		int total = scan.nextInt();
		
		int[] vals = new int[total+1];
		int[] coinUsed = new int[total+1];
		for (int i = 0; i < total+1; i++){
			vals[i]=2000000000;
			coinUsed[i]=-1;
		}
		vals[0]=0;
		
		int currentCoin;
		int usedValue;
		for (int i = 0; i < numCoins; i++){
			currentCoin = coins[i];
			
			for (int j = 0; j < total+1; j++){
				if (j < currentCoin){
					continue;
				}
				
				usedValue = j-currentCoin;
				if (vals[usedValue]+1 < vals[j]){
					vals[j]=vals[usedValue]+1;
					coinUsed[j]=i;
				}
				
			}
			
		}
		
		System.out.println(vals[total]);
		int index = total;
		while (index > 0){
			System.out.print(coins[coinUsed[index]]+" ");
			index -= coins[coinUsed[index]];
		}
	}

}







