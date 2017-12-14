package Feb15hmwk;
import java.util.Scanner;
public class BankLoans {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter number of banks and the money minimum: ");
		int banks = scan.nextInt();
		int min = scan.nextInt();
		int tempNum;
		int tempBank;
		double tempLoan;
		boolean stable = false;   // are the banks stable?
		double [][] balance = new double[banks][banks+1];  // extra column for balance of each bank
		for (int i = 0; i < banks; i++){
			balance[i][banks] = scan.nextInt();
			tempNum = scan.nextInt();
			for (int j = 0; j < tempNum; j++){  // for every pair
				tempBank = scan.nextInt();
				tempLoan = scan.nextDouble();
				balance[i][tempBank] = tempLoan;
			}
		}
		while (!stable){
			stable = true;   // assume bank conditions are stable until proved otherwise
			for(int i = 0; i < banks; i++){  // for every bank:
				if (arraySum(balance[i])<min){  // if bank is unstable
					stable = false;
					for (int j = 0; j < banks; j++){  // all assets become 0
						balance[i][j] = 0;
					}
					for (double[] k : balance){  // loans to other banks become 0
						k[i] = 0;
					}
				}
			}
		}
		System.out.print("Unsafe banks are: ");
		for (int i = 0; i < banks; i++){
			if (arraySum(balance[i]) == 0)
				System.out.print(i+" ");
		}
	}
	
	public static double arraySum(double[]array){
		double sum = 0; 
		for (double i: array){
			sum += i;
		}
		return sum;
	}

}
