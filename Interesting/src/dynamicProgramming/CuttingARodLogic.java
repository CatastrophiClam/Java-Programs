package dynamicProgramming;

import java.util.Scanner;
import java.util.ArrayList;

public class CuttingARodLogic {
	ArrayList<Integer> prices;
	ArrayList<Integer> maxPrices = new ArrayList<Integer>();

	public CuttingARodLogic() {

	}

	public void setPrices(ArrayList<Integer> prices) {
		this.prices = prices;
	}

	/**
	 * 
	 * @param length
	 * @returns maximum price of rod with length length
	 */
	public int maxPrice(int length){
		maxPrices.add(0);
		maxPrices.add(prices.get(1));
		int currentMax = 0;
		for (int i = 2; i <= length; i++){
			//set max price for rod of length i to its uncut price
			if (i < prices.size()){
				currentMax = prices.get(i);
			}
			for (int j = 1; j < i; j++){
				if (maxPrices.get(j)+maxPrices.get(i-j)>currentMax){
					currentMax = maxPrices.get(j)+maxPrices.get(i-j);
				}
			}
			maxPrices.add(currentMax);
		}
		return maxPrices.get(length);
		
	}

}
