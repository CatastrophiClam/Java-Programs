package challenges;
import java.util.*;
import java.lang.Math;

public class FactorialFactor {
	static int[] key = new int[500000];
	static int[] obj = new int[500000];
	int M = 98162316;
	int N = 6546516;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter m: ");
		int m = scan.nextInt();
		System.out.println("Enter n: ");
		int n = scan.nextInt();
		if (n > m){
			System.out.println(m+" divides "+n+"!");
			return;
		}
		primeFactorize(m);
		
		if (key.length==0){
			System.out.println(m+" does not divide "+n+"!");
		}
		boolean divides = true;
		boolean finished = false;
		int temp;
		for (int i = n; i <1;i--){
			finished = true;
			for (int j = 0; j < key.length;){
				temp = i;
				if (obj[j]==0){
					j++;
					continue;
				}else{
					finished = false;
				}
				while(temp%key[j]==0){
					obj[j]--;
					temp/=key[j];
				}
			}
			if (finished){
				System.out.println(m+" divides "+n+"!");
				return;
			}
		}
		System.out.println(m+" does not divide "+n+"!");
		
	}	
	
	public static void primeFactorize(int n){
		int c;
		int i = 0;
		while (n%2==0){
			n/=2;
			if (key[0]==2){
				obj[i]++;
			}else{
				key[0]=2;
				obj[0]=1;
			}
		}
		c=3;
		double max = Math.sqrt(n);
		while (c < max+1){
			if (n%c==0){
				if (key[i]==c){
					obj[i]++;
				}else{
					i++;
					key[i]=c;
					obj[i]=1;
				}
			}else{
				c+=2;
			}
		}
	}

}
