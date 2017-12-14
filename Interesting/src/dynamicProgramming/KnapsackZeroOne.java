package dynamicProgramming;
import java.util.*;

public class KnapsackZeroOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter number of benefits: ");
		int numBenefits = scan.nextInt();
		int[] benefits = new int[numBenefits];
		int[] weights = new int[numBenefits];
		
		System.out.println("Enter value of benefits: ");
		for (int i = 0; i < numBenefits; i++){
			benefits[i]=scan.nextInt();
		}
		System.out.println("Enter weight of benefits: ");
		for (int i = 0; i < numBenefits; i++){
			weights[i]=scan.nextInt();
		}
		
		System.out.println("Enter total weight: ");
		int totalWeight = scan.nextInt();
		
		int[][]table = new int[numBenefits][totalWeight+1];
		
		//i corresponds to benefit/weight, j corresponds to total weight allowed
		for (int i = 0; i < numBenefits; i++){
			for (int j = 1; j <= totalWeight; j++){
				if (weights[i]<=j){
					table[i][j]=max(table[max(i-1,0)][j], benefits[i]+table[max(i-1,0)][j-weights[i]]);
				}else{
					table[i][j]=table[max(i-1,0)][j];
				}
			}
		}
		
		System.out.println("The maximum value is: "+table[numBenefits-1][totalWeight]);
		
		int i = numBenefits-1;
		int j = totalWeight;
		
		while (j>0){
			if (i == 0){
				if (j!=0)
					System.out.println(benefits[i]);
				return;
			}
			if (table[i][j]==table[i-1][j]){
				i--;
				continue;
			}else{
				System.out.print(benefits[i]+" ");
				j-=weights[i];
				i--;
			}
		}
	}
	
	public static int max(int a, int b){
		if (a > b){
			return a;
		}
		return b;
	}

}
