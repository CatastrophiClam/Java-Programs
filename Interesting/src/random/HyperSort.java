package random;
import java.util.ArrayList;
import java.lang.Math;

/**
 * Insertion sort with binary insertion
 * @author Max
 *
 */
public class HyperSort {
	ArrayList<Double> outputList = new ArrayList<Double>();
	double[] inputList;
	
	public HyperSort(){
		
	}
	
	/**
	 * 
	 * @param list
	 * @returns an arrayList containing the elements from list from smallest to largest
	 */
	public ArrayList<Double> sort(double[] list){
		for (double i: list){
			if (outputList.size()!= 0){
				binaryInsert(outputList, i);
			}else{
				outputList.add(i);
			}
		}
		return outputList;
	}
	
	public static void binaryInsert(ArrayList<Double>array, double regex){
		boolean done = false;
		int checkRange = array.size()-1;  // range of numbers to check from checkPlace
		int nowIndex =checkRange/2-1;   // index we start from 
		while (!done){
			if (nowIndex > 0){
				if (array.size() > 1){
					if (nowIndex == array.size()){
						array.add(nowIndex, regex);
					//if we found the right place:
					}else 
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
		}
		//System.out.print(regex + " ");
	}
}
