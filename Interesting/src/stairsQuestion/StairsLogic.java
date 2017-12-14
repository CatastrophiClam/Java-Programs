package stairsQuestion;
import java.util.ArrayList;
import java.lang.Math;
public class StairsLogic {
	int n;
	int answer;
	ArrayList<Integer> temp;
	ArrayList<int[]> allStepCombos = new ArrayList<int[]>();  // array of all possible combinations of steps at a time
	
	public StairsLogic(){
		allStepCombos.add(new int[] {1});
		allStepCombos.add(new int[] {2});
		allStepCombos.add(new int[] {3});
		allStepCombos.add(new int[] {1,2});
		allStepCombos.add(new int[] {2,3});
		allStepCombos.add(new int[] {1,3});
		allStepCombos.add(new int[] {1,2,3});
	}
	/**
	 * 
	 * @param n number of stairs
	 * @return number of different ways to go up those stairs
	 */
	public int calculate(int n){
		this.n = n;
		for (int[] array:allStepCombos){
			ArrayList<ArrayList<Integer>> totalArray = findPossibleCombinations(array);
			for (ArrayList<Integer> ar: totalArray){
				answer += permutate(ar); // add possibilities
			}
		}
		return answer;
	}
	
	/**
	 * 
	 * @param numbers: numbers usable
	 * @return returns all different combos (order doesn't matter) of numbers usable that add up to n
	 */
	public ArrayList<ArrayList<Integer>> findPossibleCombinations(int[] numbers){ 
		ArrayList<ArrayList<Integer>> totalArrays = new ArrayList<ArrayList<Integer>>();
		if (numbers.length == 1){        // if there's only one number usable
			totalArrays.add(new ArrayList<Integer>());
			if (n%numbers[0]==0){        // if n is divisible by that number, there is one possibility
				totalArrays.get(0).add(1);
			}else{
				totalArrays.get(0).add(1);
			}
			return totalArrays;
		}else if(numbers.length == 2){
			totalArrays.add(find2Nums(numbers[0],numbers[1]));
		}
	}
	
	/**
	 * 
	 * @param num1 first number
	 * @param num2 second number
	 * @param total the total
	 * @return arraylist of the different combos of num1 and num2 that add up to total
	 */
	public ArrayList<Integer> find2Nums(int num1, int num2, int total){
		int numOf1 = total/num1;
	}
	
	public int findSCF(int num1, int num2){ // finds smallest common factor of 2 numbers
		int i = 1;
		while (i <= num2){
			if (num1*i % num2 == 0){
				return num1*i;
			}
			i++;
		}
		return 0;
	}
	
	/**
	 * 
	 * @param numbers array containing number of each different number
	 * @return number of all possible permutations of this array (order matters here)
	 */
	public int permutate(ArrayList<Integer> numbers){
		int top = 0;
		int bottom = 1;
		for (int i:numbers){
			top += i;
			bottom = bottom*factorial(i);
		}
		top = factorial(top);
		return top/bottom;
	}
	
	public int factorial(int num){ // returns factorial of num
		if (num>0){
			int total = 1;
			for (int i = 1; i <= num; i++){
				total = total*i;
			}
			return total;
		}else{
			return 0;
		}
	}
	
	/**
	 * 
	 * @param array: The array to find all the subsets of
	 * @param maxSize: maximum size of a subset
	 * @return: All subsets of array
	 */
	public ArrayList<int[]> findAllSubsets(ArrayList<Integer> array, int maxSize){  //NOT DONE
		ArrayList<int[]> finalArray = new ArrayList<int[]>();
		for (int i = 1; i <= array.size(); i++){  // size of subset - for each:
			// find all subsets starting with a number
			for (int j = 0; j <= array.size()-i; j++){   //number to start from
				for (int k = j; k < array.size(); k++){
					temp = new ArrayList<Integer>();
					temp.add(array.get(j));
					for (int l = 0; l < i; l++){
						temp.add(array.get(k+l));
					}
					
				}
			}
		}
		return finalArray;
	}
}
