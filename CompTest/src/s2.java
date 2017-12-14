import java.util.*;
import java.io.*;
import java.lang.Math;
public class s2 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);//new File("In"));
		int numRows = reader.nextInt();
		int numCols = reader.nextInt();
		int[][] lights = new int[numRows][numCols];
		for (int i = numRows-1; i >= 0; i--){
			for (int j = 0; j < numCols; j++){
				lights[i][j] = reader.nextInt();
			}
		}
		
		ArrayList<int[]> lastPossibilities = new ArrayList<int[]>();
		ArrayList<int[]> currentPossibilites = new ArrayList<int[]>();
		ArrayList<int[]> temp = new ArrayList<int[]>();
		HashSet<Integer> visited = new HashSet<Integer>();
		int[] tempArray;
		
		lastPossibilities.add(lights[numRows-1]);
		int val;
		
		for (int i = numRows-2; i >= 0; i--){
			visited.clear();
			for (int j = 0; j < lastPossibilities.size(); j++){
				tempArray = press(lastPossibilities.get(j),lights[i]);
				val = code(tempArray);
				if (!visited.contains(val)){
					visited.add(val);
					currentPossibilites.add(tempArray);
				}
			}
			lastPossibilities.clear();
			temp = currentPossibilites;
			currentPossibilites = lastPossibilities;
			lastPossibilities = temp;
		}
		System.out.println(lastPossibilities.size());
	}
	
	public static int[] press(int[] a, int[] b){
		int[] answer = new int[a.length];
		for (int i = 0; i < a.length; i++){
			if (a[i]==b[i]){
				answer[i] = 0;
			}else{
				answer[i]=1;
			}
		}
		return answer;
	}
	
	public static int code(int[] arr){
		int ans = 0;
		for (int i = 0; i < arr.length; i++){
			if (arr[i]==1){
				ans += (int)(Math.pow(2, i));
			}
		}
		return ans;
	}

}
