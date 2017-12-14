package usaco;
import java.util.*;
import java.io.*;

/*
ID: Max
LANG: JAVA
TASK: barn1
*/

public class barn1 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new FileReader("barn1.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("barn1.out")));
		
		String[] buffer = reader.readLine().split(" ");
		int maxBoards = Integer.parseInt(buffer[0]);
		int numStalls = Integer.parseInt(buffer[1]);
		int numCows = Integer.parseInt(buffer[2]);
		
		boolean[] stalls = new boolean[numStalls+1];
		
		int temp;
		int max = 0;

		for (int i = 0; i < numCows; i++){
			temp = Integer.parseInt(reader.readLine().split(" ")[0]);
			stalls[temp] = true;
			if (temp > max){
				max = temp;
			}
		}
		
		ArrayList<Integer> gaps = new ArrayList<Integer>();
		int tempCount = 0;
		boolean past = false;
		int i = 0;
		
		while(!past){
			i++;
			past = stalls[i];
		}
		
		int start = i;
		for (;i<=max;i++){
			if (stalls[i]==past){
				if (!stalls[i]){
					tempCount++;
				}
			}else{
				if (stalls[i]){
					gaps.add(findInsertPos(tempCount,gaps),tempCount);
					tempCount = 0;
				}else{
					tempCount = 1;
				}
			}
			past = stalls[i];
		}
		
		int total = max - start + 1;
			
			
		//System.out.println(max);
		//System.out.println(gaps);
		//System.out.println(total);
		
		for (i = 0; i < maxBoards-1; i++){
			if (gaps.size() > 0){
				total -= gaps.remove(gaps.size()-1);
			}else{
				break;
			}
		}
		//System.out.println(min);
		
		out.println(total);
		
		reader.close();
		out.close();
		System.exit(0);
	}
	
	public static int findInsertPos(int a, ArrayList<Integer> list){
		int min = 0;
		int max = list.size();
		int findIndex;
		while (true){
			if (max==0){
				return 0;
			}else if(max == 1){
				if (a >= list.get(0)){
					return 1;
				}else{
					return 0;
				}
			}else{
				findIndex = (min+max)/2;
				if (findIndex == 0){
					if (a <= list.get(0)){
						return 0;
					}else{
						min = 1;
					}
				}else if (findIndex == list.size()-1){
					if (list.get(findIndex)>=a){
						if (list.get(findIndex-1)<=a){
							return findIndex;
						}else{
							max = findIndex-1;
						}
					}else{
						return findIndex+1;
					}
				}else if (list.get(findIndex-1)<=a){
					if (list.get(findIndex)>=a){
						return findIndex;
					}else{
						min = findIndex;
					}
				}else{
					max = findIndex;
				}
			}
		}
		
	}

}
