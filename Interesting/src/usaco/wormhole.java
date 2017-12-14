package usaco;

import java.io.*;
import java.util.*;

/*
ID: Max
LANG: JAVA
TASK: wormhole
*/

public class wormhole {
	static int[][]paths;
	static ArrayList<Integer> xCoords;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new FileReader("wormhole.in"));
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("wormhole.out")));
		//BufferedReader reader = new BufferedReader(new FileReader("Test.txt.txt"));
		//PrintStream writer = System.out;
		
		int n = Integer.parseInt(reader.readLine());
		String[] buffer = new String[2];
		
		ArrayList<Integer> yVals = new ArrayList<Integer>();
		HashMap<Integer,Integer> yCounts = new HashMap<Integer,Integer>();
		int y;
		int tempInt;
		for (int i = 0; i < n; i++){
			buffer = reader.readLine().split(" ");
			y = Integer.parseInt(buffer[1]);
			if (yCounts.containsKey(y)){
				tempInt = yCounts.get(y)+1;
				yCounts.remove(y);
				yCounts.put(y,tempInt);
			}else{
				yCounts.put(y,1);
				yVals.add(y);
			}
		}
		
		int total = 0;
		int count = 1;
		ArrayList<Hole> pool = new ArrayList<Hole>();
		ArrayList<Hole> all = new ArrayList<Hole>();
		
			for (int i= 0; i < yVals.size(); i++){
				int j = yCounts.get(yVals.get(i));
				for (int k = 0; k < j; k++){
					pool.add(new Hole(count));
					count++;
					all.add(pool.get(pool.size()-1));
					if (k != 0){
						pool.get(pool.size()-2).setNext(pool.get(pool.size()-1));
					}
					if (k == j-1){
						pool.get(pool.size()-1).setNext(null);
					}
				}
			}
			//for (int i = 0; i < all.size();i++){
			//	System.out.println(all.get(i)+": Wormhole to "+all.get(i).to+", Walk to "+all.get(i).next);
			//}
			total += combAndCheck(pool,all);///factorial(all.size()/2);
		
		
		
		writer.println(total);
		
		writer.close();
		reader.close();
		System.exit(0);
	}
	
	public static int factorial(int n){
		int total = 1;
		for (int i = n; i > 1; i--){
			total *= i;
		}
		return total;
	}
	
	public static int combAndCheck(ArrayList<Hole> pool,ArrayList<Hole> all){
		Hole tHole1;
		Hole tHole2;
		int total = 0;
		if (pool.size()>1){
			int i = 0;
				for (int j = i+1; j < pool.size(); j++){
					tHole1 = pool.get(i);
					tHole2 = pool.get(j);
					tHole1.setTo(tHole2);
					tHole2.setTo(tHole1);
					pool.remove(i);
					pool.remove(j-1);
					total += combAndCheck(pool,all);
					pool.add(i,tHole1);
					pool.add(j,tHole2);
					tHole1.reset();
					tHole2.reset();
				}
			
		}else{
			if (check(all)){
				return 1;
			}
		}
		return total;
	}
	
	public static boolean check(ArrayList<Hole> all){
		//boolean check = false;
		//if (all.get(0).to.num == 3 && all.get(1).to.num == 4){
		//	check = true;
		//}
		for (int i = 0; i < all.size(); i++){
			if (checkCycle(i,all)){
				//System.out.println();
				//for (int j = 0; j < all.size();j++){
				//	System.out.println(all.get(j)+": Wormhole to "+all.get(j).to+", Walk to "+all.get(j).next);
				//}
				//if (check){
				//	System.out.println(i);
				//}
				return true;
			}
		}
		return false;
	}
	
	public static boolean checkCycle(int start, ArrayList<Hole> all){
		Hole now = all.get(start);
		boolean teleport = true;
		for (int i = 0; i < all.size()*2; i++){
			if (teleport){
				now = now.to;
				teleport = false;
			}else{
				now = now.next;
				teleport = true;
			}
			if (now == null){
				return false;
			}
		}
		return true;
	}
	
	public static ArrayList<ArrayList<Integer>> getCombs(int size){
		ArrayList<ArrayList<Integer>> all = new ArrayList<ArrayList<Integer>>();
		all.add(new ArrayList<Integer>());
		if (size == 1){
			all.get(0).add(0);
		}else{
			all.get(0).add(size);
			ArrayList<ArrayList<Integer>> temp = getCombs(size-1);
			for (ArrayList<Integer> i:temp){
				all.add(new ArrayList<Integer>(i));
				i.add(size-1);
				all.add(i);
			}
		}
		return all;
	}
	
	static class Hole{
		Hole next;
		Hole to;
		int num;
		
		Hole (Hole next){
			this.next = next;
		}
		
		Hole(int num){
			this.num = num;
			this.to= null;
		}
		
		void setTo(Hole to){
			this.to = to;
		}
		
		void setNext(Hole next){
			this.next = next;
		}
		
		void reset(){
			to = null;
		}
		
		@Override
		public String toString(){
			return String.valueOf(num);
		}
	}

}
