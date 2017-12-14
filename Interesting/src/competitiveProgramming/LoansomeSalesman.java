package competitiveProgramming;

import java.util.Scanner;
import java.util.ArrayList;
public class LoansomeSalesman {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int duration = scan.nextInt();
		double downPayment, loan, carValue,toPay;
		int numRecords,month;
		ArrayList<Integer> months = new ArrayList<Integer>();
		ArrayList<Double> rates = new ArrayList<Double>();
		
		while(duration > 0){
			//System.out.println("//==============//\n");
			downPayment = scan.nextDouble();
			loan = scan.nextDouble();
			toPay = loan/duration;
			carValue = downPayment+loan;
			numRecords = scan.nextInt();
			month = 0;
			months.clear();
			rates.clear();
			
			for (int i = 0; i < numRecords; i++){
				months.add(scan.nextInt());
				rates.add(scan.nextDouble());
			}
			
			outer:
			for (int i = 0; i < months.size(); i++){
				while(i == months.size()-1 ||month < months.get(i+1) ){
					if (month != 0){
						loan -= toPay;
					}
					carValue *=(1-rates.get(i));
					if (carValue>loan){
						break outer;
					}
					month++;
				}
			}
			
			if (month == 1){
				System.out.println("1 month");
			}else{
				System.out.printf("%d months\n",month);
			}
			duration = scan.nextInt();
		}
	}

}
