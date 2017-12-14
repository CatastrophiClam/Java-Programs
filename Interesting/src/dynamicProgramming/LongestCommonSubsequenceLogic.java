package dynamicProgramming;
import java.util.ArrayList;

public class LongestCommonSubsequenceLogic {
	char[] s1,s2;
	ArrayList<Integer> sa1 = new ArrayList<Integer>();
	ArrayList<ArrayList<Integer>> sa2 = new ArrayList<ArrayList<Integer>>();
	int[] poss;
	int maxLength = 0;
	int[]maxChain;
	
	public LongestCommonSubsequenceLogic(){
		
	}
	
	public void setStr1 (String s1){
		this.s1 = s1.toCharArray();
	}
	
	public void setStr2 (String s2){
		this.s2 = s2.toCharArray();
	}
	
	public String find(){
		//find common chars
		for (int i = 0; i < s1.length; i++){
			for (int j = 0; j < s2.length; i++){
				if (s1[i] == s2[j]){
					if (sa1.contains(i)){
						sa2.get(sa2.size()-1).add(j);
					}else{
						ArrayList<Integer> temp = new ArrayList<Integer>();
						temp.add(j);
						sa1.add(i);
						sa2.add(temp);
					}
				}
			}
		}
		poss = new int[sa2.size()];
		process(0);
	}
	
	public void process(int l){
		for (int i = 0; i < sa2.get(l).size(); i++){
			poss[l] = sa2.get(l).get(i);
			if (l < sa2.size()-1){
				process(++l);
			//we're at end of one chain
			}else{
				maxLength = findMaxLength(poss);
			}
		}
	}
	
	public int findMaxLength(int[] arr){
		int pastInt = -1;
		int maxLength = 1;
		ArrayList<Integer> tempArray = new ArrayList<Integer>();
		int[] ta;
		for (int i = 0; i < arr.length; i++){
			if (arr[i] > pastInt){
				pastInt = arr[i];
				maxLength ++;
				if (i+1 < arr.length && arr[i] < pastInt){
					
				}
			}else{
				
			}
		}
	}
}
