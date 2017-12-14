package sorters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class SortTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random random = new Random();
		StopWatch watch = new StopWatch();
		int numNum = 200000;
		int[] numbers = new int[numNum];
		for (int i = 0; i < numNum; i++){
			numbers[i] = random.nextInt(numNum);
		}
		watch.start();
		Arrays.sort(numbers);
		watch.stop();
		//ArrayList<Double> result = sorter.sort(new double[]{4, 1, 5, 2, 6, 3, 4, 2, 1});
		for (int i = 0; i < numbers.length; i++){
			System.out.println(numbers[i]);
		}
		System.out.print(watch.timeElapsed());
	}
}


