package challenges;
import java.lang.Math;

/**
 * 
 * @author Max
 *Test if the algorithm that: if there are m factors of the prime number f in the number x!, m = sum(x/=f)
 */

public class FindPrimeFactorsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long product = 1;
		int power;
		int temp;
		int total;
		for (int i = 1; i < 200; i++){
			product *= i;
			temp = i;
			power = 0;
			while (temp > 0){
				power += temp/2;
				temp/=2;
			}
			total = (int)(Math.pow(2, power));
			System.out.println(i+": "+product/total%2);
			//System.out.println(i+"!: 2^"+power+": "+product+"/"+total+"="+product/total);
		}
	}

}
