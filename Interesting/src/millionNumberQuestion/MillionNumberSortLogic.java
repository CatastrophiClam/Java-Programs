package millionNumberQuestion;
import java.util.Random;
import java.util.ArrayList;
import java.lang.Math;
public class MillionNumberSortLogic {
	public static void main(String[]args){
		Random random = new Random();
		int numOfNumbers = 1000000;
		int[] masterArray = new int[numOfNumbers]; // array to be sorted
		StopWatch stopwatch = new StopWatch();
		ArrayList<Integer> ints = new ArrayList<Integer>();
		for (int i = 0; i < numOfNumbers; i++){  // fill array
			masterArray[i] = random.nextInt(numOfNumbers*1000);
		}
		stopwatch.start();
		ints.clear();
		// for every number in MasterArray
		for (int i = 0; i < numOfNumbers; i++){    // NOTE ints is sorted from biggest to smallest
			if (ints.size() != 0){  // if there are things in ints
				if (ints.size() < 99){   // if array isn't full:
					binaryInsert(ints, masterArray[i]);
				}else{
					if (masterArray[i] > ints.get(ints.size()-1)){   // if the number is bigger than the smallest number
						binaryInsert(ints, masterArray[i]);
					}
				}
			}else{
				ints.add(i);
			}
		}
		stopwatch.stop();
		for (int i: ints){
			System.out.print(i+",");
		}
		System.out.println();
		System.out.print("The running time was: "+stopwatch.timeElapsed());
	}
	
	public static void binaryInsert(ArrayList<Integer>array, int regex){
		boolean done = false;
		int checkRange = array.size();  // range of numbers to check from checkPlace
		int nowIndex =checkRange/2;   // index we start from 
		while (!done){
			if (nowIndex > 0){
				if (array.size() > 1){
					if (array.get(nowIndex-1)>=regex&&regex>=array.get(nowIndex)){
						array.add(nowIndex, regex);
						done = true;
					}else if(array.get(nowIndex-1) < regex){  // if nowIndex needs to be moved to the left
						nowIndex = (int)(nowIndex - Math.ceil(checkRange/4.0));
						checkRange = checkRange/2;
					}else{              // if nowIndex needs to be moved to the right
						nowIndex = (int) (nowIndex + Math.ceil(checkRange/4.0));
						checkRange = checkRange/2;
					}
				// if there's only one number in array	
				}else{    
					if (array.get(0)> regex){
						array.add(regex);
						done = true;
					}else{    
						array.add(0, regex);
						done = true;
					}
				}
				// if nowIndex is 0, regex is the biggest
			}else{   
				array.add(0, regex);
				done = true;
			}
			if (array.size()>100){
				array.remove(array.size()-1);
			}
		}
		//System.out.print(regex + " ");
	}
}
