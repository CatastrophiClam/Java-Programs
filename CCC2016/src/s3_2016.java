import java.util.*;
import java.io.*;
public class s3_2016 {
	static int numRestaurants,numPho;
	static ArrayList<Integer> phoArray;
	static HashMap<Integer,ArrayList<Integer>> graph;
	static HashMap<Integer,Integer>key;
	static int[][] distances;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(new File("Test"));
		numRestaurants = reader.nextInt();
		numPho = reader.nextInt();
		distances = new int[numPho][numPho];
		key = new HashMap<Integer,Integer>();
		phoArray = new ArrayList<Integer>();
		int temp;
		for (int i = 0; i < numPho; i++){
			temp = reader.nextInt();
			phoArray.add(temp);
			key.put(temp,i);
		}
		graph = new HashMap<Integer,ArrayList<Integer>>();
		int a,b;
		for (int i = 0; i < numRestaurants-1; i++){
			a = reader.nextInt();
			b = reader.nextInt();
			if (!graph.containsKey(a)){
				graph.put(a, new ArrayList<Integer>());
				graph.get(a).add(b);
			}else{
				graph.get(a).add(b);
			}
			if (!graph.containsKey(b)){
				graph.put(b, new ArrayList<Integer>());
				graph.get(b).add(a);
			}else{
				graph.get(b).add(a);
			}
		}
		int count = 0;
		int tempCount = 0;
		ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
		ArrayList<Integer> toVisit;
		HashSet<Integer> visited=  new HashSet<Integer>();
		int current;
		int numToVisit;
		for (int i = 0; i < numPho; i++){
			queue.clear();
			queue.add(phoArray.get(i));
			numToVisit = numPho-1-i;
			count = 0;
			tempCount = 0;
			visited.clear();
			while(!queue.isEmpty()&&numToVisit>0){
				if (tempCount > 0){
					tempCount--;
				}
				current = queue.remove();
				visited.add(current);
				toVisit = graph.get(current);
				for (int j : toVisit){
					if (!visited.contains(j)){
						if (key.containsKey(j)){
							if (distances[key.get(phoArray.get(i))][key.get(j)]==0){
								distances[key.get(phoArray.get(i))][key.get(j)] = count+1;
								distances[key.get(j)][key.get(phoArray.get(i))] = count+1;
								numToVisit--;
							}
						}
						queue.add(j);
					}
				}
				if (tempCount == 0){
					count++;
					tempCount = queue.size();
				}
			}
		}
		int minTime= 1000000000;
		int tempTime;
		for (int i = 0; i < numPho; i++){
			visited.clear();
			tempTime = minTime(phoArray.get(i),visited);
			if (tempTime < minTime){
				minTime = tempTime;
			}
		}
		System.out.println(minTime);
	}
	
	public static int minTime(int i, HashSet<Integer>visited){
		visited.add(i);
		int minTime = 1000000000;
		int tempTime;
		if (visited.size()==numPho){
			visited.remove(i);
			return 0;
		}
		for (int j : phoArray){
			if (!visited.contains(j)){
				tempTime = distances[key.get(i)][key.get(j)]+minTime(j,visited);
				if (tempTime < minTime){
					minTime = tempTime;
				}
			}
		}
		visited.remove(i);
		return minTime;
	}

}
