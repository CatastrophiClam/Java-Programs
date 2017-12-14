package ccc;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;
public class s4_2013Better {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		File file = new File("Test.txt.txt");
		Scanner reader = new Scanner(file);
		StopWatch watch = new StopWatch();
		watch.start();
		int numPeople = reader.nextInt();
		int numCompared = reader.nextInt();
		ArrayList<ArrayList<Integer>>tallers = new ArrayList<ArrayList<Integer>>();
		tallers.add(new ArrayList<Integer>());
		int[] keys = new int[numPeople+1];
		int b;
		int s;
		for (int i = 0; i < numCompared; i++){
			b = reader.nextInt();
			s = reader.nextInt();
			if (keys[b] != 0){
				tallers.get(keys[b]).add(s);
			}else{
				keys[b] = tallers.size();
				tallers.add(new ArrayList<Integer>());
				tallers.get(tallers.size()-1).add(s);
			}
		}
		int p = reader.nextInt();
		int q = reader.nextInt();
		if (search(p,q,tallers,keys,numPeople)){
			System.out.println("Yes");
		}else if (search(q,p,tallers,keys,numPeople)){
			System.out.println("No");
		}else{
			System.out.println("Unknown");
		}
		watch.stop();
		System.out.print(watch.timeElapsed());
	}
	
	public static boolean search(int p, int q, ArrayList<ArrayList<Integer>> tallers, int[]keys, int num){
		if (keys[p]!= 0){
			int a;
			boolean[] visited = new boolean[num+1];
			for (int i = 0; i < num+1;i++){
				visited[i] = false;
			}
			PriorityQueue<Integer> list = new PriorityQueue<Integer>();
			for (int i:tallers.get(keys[p])){
				list.add(i);
			}
			while(list.size()>0){
				a = list.poll();
				if (a == q){
					return true;
				}else{
					if (!visited[a]){
						visited[a] = true;
						for (int j:tallers.get(keys[a])){
							list.add(j);
						}
					}
				}
			}
			return false;
		}
		return false;
	}

}







