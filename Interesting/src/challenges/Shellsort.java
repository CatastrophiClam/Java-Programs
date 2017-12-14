package challenges;
import java.io.*;
import java.util.*;

public class Shellsort {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new FileReader("Files/In"));
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("Files/Out")));
		int numCases = Integer.parseInt(reader.readLine());
		for (int i = 0; i < numCases; i++){
			process(reader,writer);
		}
		System.out.println("");
	}
	
	public static void process(BufferedReader reader,PrintWriter writer) throws IOException{
		int numTurtles = Integer.parseInt(reader.readLine());
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		HashMap<Integer, String> key = new HashMap<Integer, String>();
		String[] rand = new String[numTurtles];
		for (int i = 0; i < numTurtles; i++){
			rand[i] = reader.readLine();
		}
		String temp;
		for (int i = 0; i < numTurtles; i++){
			temp = reader.readLine();
			map.put(temp, i);
			key.put(i, temp);
		}
		int l = map.get(rand[0]);
		int popFrom = -1;
		int val;
		for (int i = 1; i < numTurtles; i++){
			val = map.get(rand[i]);
			if (val>l){
				l = val;
			}else{
				if (val > popFrom){
					popFrom = val;
				}
			}
		}
		for (int i = popFrom; i > 0; i--){
			System.out.println(key.get(i));
		}
		
	}

}
