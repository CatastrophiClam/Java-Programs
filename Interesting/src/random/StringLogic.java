package random;
import java.util.ArrayList;

public class StringLogic {
	String string;

	public StringLogic(){
		
	}
	
	public String maximumIncOrderSubsequence(String string){
		this.string = string;
		ArrayList<ArrayList<Integer>> all = new ArrayList<ArrayList<Integer>>();
		int maxValue;
		int chosenIndex;
		int biggestValue = 0;
		int biggestIndex = 0;
		String answer = "";
		//for every char in string
		for (int i = 0; i < string.length(); i++){
			// temp is representative of i in all
			ArrayList<Integer> temp = new ArrayList<Integer>(); // first number in temp is value of path, rest is path in indexes
			if (i == 0){
				temp.add(0+string.charAt(0));
				temp.add(0);
			}else{
				maxValue = 0;
				chosenIndex = -1; // the one we pick to add before i
				//compare the char at i to everything before it
				for (int j = 0; j < i; j++){
					// if the char at i is bigger:
					if (string.charAt(i)>string.charAt(j)){
						// if the value of j's path is bigger than maxValue
						if (all.get(j).get(0) > maxValue){
							//update maxValue
							maxValue = all.get(j).get(0);
							//choose j as index
							chosenIndex = j;
						}
					}
				}
				// if we found a smaller thing
				if (chosenIndex!= -1){
					temp.add(all.get(chosenIndex).get(0)+string.charAt(i)); // update value of the thing at i
					for (int k = 1; k < all.get(chosenIndex).size(); k++){
						temp.add(all.get(chosenIndex).get(k));
					}
					temp.add(i);
				}else{
					// there is no chosen index, char at j is the smallest in the string 
					temp.add(0+string.charAt(i));
					temp.add(i);
				}
			}
			all.add(temp);
			// update the chosen strand
			if (temp.get(0) > biggestValue){
				biggestValue = temp.get(0);
				biggestIndex = i;
			}
		}
		// find path
		for (int i = 1; i < all.get(biggestIndex).size(); i++){
			answer +=string.charAt(all.get(biggestIndex).get(i));
		}
		return answer;
	}
}
