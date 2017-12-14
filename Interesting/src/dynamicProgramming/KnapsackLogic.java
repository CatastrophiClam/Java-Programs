package dynamicProgramming;
import java.util.ArrayList;
public class KnapsackLogic {
	int[] weights;
	int[] benefits;
	int[][]values;
	boolean[][]keep;
	public KnapsackLogic (){
		
	}
	
	public void setWeights(int[] weights){
		this.weights = weights;
	}
	
	public void setBenefits(int[]benefits){
		this.benefits = benefits;
	}
	
	public int max(int int1, int int2){
		if (int1 > int2){
			return int1;
		}else{
			return int2;
		}
	}
	
	public ArrayList<Integer> solve(int maxWeight){
		values = new int[maxWeight][weights.length];
		keep = new boolean[maxWeight][weights.length];
		int current;
		int past;
		int maximumOther = 0;
		boolean found = false;
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for (int i = 0; i < maxWeight; i++){
			values[i][0] = 0;
		}
		//for every square in the grid
		for (int i = 1; i < weights.length; i++){ //i is current number of items
			for (int j = 1; j <= maxWeight; j++){ //j is current max weight
				if (weights[i-1] > j){
					values[j-1][i] = 0;
					keep[j-1][i] = false;
					continue;
				}
				//find maximum benefit of remaining weight
				for (int k = 0; k < weights.length; k++){
					if (j-weights[i-1] > 0){
						if (values[j-weights[i-1]][k]>maximumOther){
							maximumOther = values[j-weights[i-1]-1][k];
						}
					}
				}
				current = weights[i-1]+maximumOther;
				if (current > values[j-1][i-1]){
					values[j-1][i] = current;
					keep[j-1][i] = true;
				}else{
					values[j-1][i] = values[j-1][i-1];
					keep[j-1][i] = false;
				}
			}
		}
		int avaWeight = maxWeight;
		found = false;
		// find weights to add
		for (int i = weights.length-1; i > 0; i--){
			if (keep[min(avaWeight, maxWeight)][i]){
				numbers.add(i);
				avaWeight -= weights[i-1];
			}else{
				found = false;
				for(int j = i-1; j >= 0; j--){
					if (keep[avaWeight-1][j]){
						found = true;
						numbers.add(j);
					}
				}
				if (!found){
					return numbers;
				}
			}
		}
		return numbers;
	}
	
	public int min (int int1, int int2){
		if (int1 > int2){
			return int2;
		}
		return int1;
	}
}




