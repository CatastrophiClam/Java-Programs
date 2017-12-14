package random;
import java.util.*;
import java.lang.*;
import java.math.BigInteger;

public class SemiPrimes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigInteger test = new BigInteger("1522605027922533360535618378132637429718068114961380688657908494580122963258952897654000350692006139");
		BigInteger control = new BigInteger("69");
		BigInteger f1 = new BigInteger("0");
		BigInteger f2 = new BigInteger("0");
		factor(control,f1,f2);
		//System.out.println(f1);
		//System.out.println(f2);
	}
	
	public static void factor(BigInteger Sp, BigInteger f1, BigInteger f2){
		BigInteger fourAC = Sp.multiply(new BigInteger("4"));
		BigInteger bS;
		BigInteger findRoot = sqrt(Sp,1).multiply(new BigInteger("2"));
		if ((findRoot.pow(2).subtract(fourAC)).mod(new BigInteger("2")).equals(new BigInteger("1"))){
			findRoot.add(new BigInteger("1")); //pairity stuff
		}
		BigInteger bSMinus4AC;
		BigInteger difference;
		BigInteger everythingOnTop;
		BigInteger i = new BigInteger("0");
		while (true){
			bSMinus4AC = (findRoot.add(i)).pow(2);
			bS = bSMinus4AC.subtract(fourAC);
			difference = sqrt(bS,1);
			if (difference.pow(2).equals(bS)){ //bS is a perfect square
				everythingOnTop = findRoot.add(new BigInteger(String.valueOf(i))).subtract(difference);
				if (everythingOnTop.mod(new BigInteger("2")).equals(new BigInteger("0"))){
					f1 = everythingOnTop.divide(new BigInteger("2"));
					System.out.println(f1);
					f2 = f1.add(difference);
					System.out.println(f2);
					System.out.println("Iterations: "+i.divide(new BigInteger("2")));
					break;
				}
			}
			i = i.add(new BigInteger("2"));
			//if (i.mod(new BigInteger("10000")).equals(new BigInteger("0"))){
				System.out.println("Iterations: "+i.divide(new BigInteger("2")));
				System.out.println("Difference: "+difference);
				System.out.println("");
			//}
		}
	}
	
	public static BigInteger sqrt(BigInteger a, int accuracy){
		BigInteger guess;
		BigInteger lastGuess = new BigInteger("-1");
		BigInteger lastLastGuess = new BigInteger("-1");
		BigInteger temp;
		BigInteger difference;
		BigInteger high = new BigInteger(a.divide(new BigInteger("2")).toString());
		BigInteger low = new BigInteger("0");
		while (true){
			guess = (high.add(low)).divide(new BigInteger("2"));
			temp = guess.pow(2);
			difference = temp.subtract(a);
			if (difference.abs().compareTo(new BigInteger(String.valueOf(accuracy)))<1){
				return guess;
			}else if(difference.compareTo(new BigInteger("0"))<1){
				low = guess;
			}else{
				high = guess;
			}
			if (guess.equals(lastGuess)||guess.equals(lastLastGuess)){
				return guess;
			}else{
				lastLastGuess = lastGuess;//.add(new BigInteger("0"));
				lastGuess = guess;//.add(new BigInteger("0"));
			}
		}
		
	}

}
