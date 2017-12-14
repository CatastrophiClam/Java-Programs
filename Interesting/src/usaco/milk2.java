package usaco;

/*
ID: Max
LANG: JAVA
TASK: milk2
*/

import java.io.*;
import java.util.*;

/**
 * I have a two arrayLists mapping the end times of each time period to its beginning time
 * if two time periods overlap, I combine them.
 * The startTimes arrayList facilitates this
 *
 */
public class milk2 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new FileReader("milk2.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("milk2.out")));
		int numFarmers = Integer.parseInt(reader.readLine());
		String[] buffer;
		
		ArrayList<Integer> startTimes = new ArrayList<Integer>();
		ArrayList<Integer> endTimes = new ArrayList<Integer>();
		
		buffer = reader.readLine().split(" ");
		startTimes.add(Integer.parseInt(buffer[0]));
		endTimes.add(Integer.parseInt(buffer[1]));
		
		int start, end, otherStart, otherEnd, insertPos;
		for (int i = 1; i < numFarmers; i++){
			buffer = reader.readLine().split(" ");
			start = Integer.parseInt(buffer[0]);
			end = Integer.parseInt(buffer[1]);
			insertPos=findInsertPos(start,startTimes);
			
			if (insertPos < startTimes.size()){
				startTimes.add(insertPos,start);
				endTimes.add(insertPos,end);
				
				//merge times if applicable
				while(true){
					if (insertPos == startTimes.size()-1){
						break;
					}
					otherStart = startTimes.get(insertPos+1);
					otherEnd = endTimes.get(insertPos+1);
					
					if (end >= otherStart){
						startTimes.remove(insertPos+1);
						if (end > otherEnd){
							endTimes.remove(insertPos+1);
						}else{
							endTimes.remove(insertPos);
						}
					}else{
						break;
					}
				}
			}else{
				startTimes.add(start);
				endTimes.add(end);
			}
			
			if (insertPos>0){
				//merge times if applicable
				otherStart = startTimes.get(insertPos-1);
				otherEnd = endTimes.get(insertPos-1);
				
				if (start <= otherEnd){
					if (otherEnd < end){
						// s S e E -> s E
						endTimes.remove(insertPos-1);
						startTimes.remove(insertPos);
					}else{
						// s S E e
						startTimes.remove(insertPos);
						endTimes.remove(insertPos);
					}
				}
			}
		}
		int longestMilkTime = 0;
		int longestNoMilkTime = 0;
		int temp;
		for (int i = 0; i < startTimes.size(); i++){
			temp = endTimes.get(i)-startTimes.get(i);
			if (temp > longestMilkTime){
				longestMilkTime = temp;
			}
			if (i < startTimes.size()-1){
				temp = startTimes.get(i+1)-endTimes.get(i);
				if (temp > longestNoMilkTime){
					longestNoMilkTime = temp;
				}
			}
		}
		out.println(longestMilkTime+" "+longestNoMilkTime);
		out.close();
		reader.close();
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
