package ccc;
import java.util.Scanner;

public class AromaticNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter aromatic number: ");
		String num = scan.nextLine();
		int total = 0;
		int roman;
		int beforeVal = -1000;
		for (int i = num.length()-1; i >= 0; i-=2){
			switch (num.charAt(i)){
				case 'M':
					roman = 1000;
					break;
				case 'D':
					roman = 500;
					break;
				case 'C':
					roman = 100;
					break;
				case 'L':
					roman = 50;
					break;
				case 'X':
					roman = 10;
					break;
				case 'V':
					roman = 5;
					break;
				case 'I':
					roman = 1;
					break;
				default:
					roman = 0;
			}
			if (roman >= beforeVal){
				total += Integer.parseInt(String.valueOf(num.charAt(i-1)))*roman;
				beforeVal = roman;
			}else{
				total -= Integer.parseInt(String.valueOf(num.charAt(i-1)))*roman;
				beforeVal = roman;
			}
		}
		System.out.print("The converted arabic number is: "+total);
	}

}
