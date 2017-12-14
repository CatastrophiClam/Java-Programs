package random;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.HashMap;

import dynamicProgramming.LongestPali;
public class Tester {
	
	static {
		
		x = 20;
	}
	
	static int x;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		StopWatch watch = new StopWatch();
		
		LongestPali logic = new LongestPali();
			//System.out.print("Enter a string: ");
			//System.out.println(logic.calc(scan.nextLine()));
		
		watch.start();
		System.out.println(logic.calc("abacbcadadcbabaabacbcadadcbabaabacbcadadcbabaabacbcadadcbaba"));
		watch.stop();
		System.out.println(watch.timeElapsed());
		
	}

}
