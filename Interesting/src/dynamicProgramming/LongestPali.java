package dynamicProgramming;
import java.lang.Math;
import java.util.HashMap;
import java.util.ArrayList;

/**
 * By: Max Dai
 * Logic is as follows: I add all the indexes of the occurences of each distinct character in the string to an arraylist mapped to that character.
 * i.e. I add all the indexes of char 'a' in string to an Arraylist mapped to 'a' in a hashmap, etc.
 * I have an Arraylist containing pairs of numbers (called pairs)
 * From each arraylist in the map, I take every combination of 2 ints from that array and add it to pairs
 * I have a method, findIn, which finds the biggest number of letters in a certain pair
 * these letters must also be from pairs
 */
public class LongestPali {
	int longest = 1;
	HashMap<Character,ArrayList<Integer>> map = new HashMap<Character,ArrayList<Integer>>();
	ArrayList<ArrayList<Integer>> pairs = new ArrayList<ArrayList<Integer>>(); // pairs of corresponding letters
	int[] numIn;
	public LongestPali(){
		
	}
	
	public int calc(String regex){
		if (regex.length() == 1){
			return 1;
		}
		int tempI;
		for (int i = 0; i < regex.length(); i++){
			if (map.containsKey(regex.charAt(i))){
				map.get(regex.charAt(i)).add(i);
			}else{
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.add(i);
				map.put(regex.charAt(i), temp);
			}
		}
		makePairs();
		//number of pairs in index
		numIn = new int[pairs.size()];
		for (int i = 0; i < numIn.length; i++){
			numIn[i] = -1;
		}
		for (int i = 0; i < pairs.size(); i++){
			tempI = findIn(i);
			if (tempI>longest){
				longest = tempI;
			}
		}
		return longest;
	}
	
	// finds maximum number of letters in pair
	public int findIn(int index){
		int num = 2;
		ArrayList<Integer> allIn = new ArrayList<Integer>();
		ArrayList<Integer> allNums = new ArrayList<Integer>();
		if (numIn[index]!=-1){
			return numIn[index];
		}else{
			allIn = findAllIn(index);
			for (int i:allIn){
				allNums.add(findIn(i));
			}
			num += max(allNums);
			if (allNums.size() == 0){
				if (pairs.get(index).get(1)-pairs.get(index).get(0)>1){
					num=3;
				}
			}
			numIn[index] = num;
			return num;
		}
	}
	
	public ArrayList<Integer> findAllIn(int index){
		ArrayList<Integer> array = new ArrayList<Integer>();
		for (int i = 0; i < pairs.size(); i++){
			if (i != index){
				if (pairs.get(i).get(0)>pairs.get(index).get(0)&&pairs.get(i).get(1)<pairs.get(index).get(1)){
					array.add(i);
				}
			}
		}
		return array;
	}
	
	public int max(ArrayList<Integer>array){
		int max = 0;
		for (int i : array){
			if (i > max){
				max = i;
			}
		}
		return max;
	}
	
	public void makePairs(){
		ArrayList<Integer> set;
		for (char i:map.keySet()){
			set = map.get(i);
			if (set.size()>1){
				//for (int j = 0; j < Math.floor(set.size()/2); j++){
				//	ArrayList<Integer> temp = new ArrayList<Integer>();
				//	temp.add(set.get(j));
				//	temp.add(set.get(set.size()-1-j));
				//	pairs.add(temp);
				//}
				for (int j = 0; j < set.size()-1; j++){
					for (int k = j+1; k < set.size(); k++){
						ArrayList<Integer> temp = new ArrayList<Integer>();
						temp.add(set.get(j));
						temp.add(set.get(k));
						pairs.add(temp);
					}
				}
			}
		}
	}
}
