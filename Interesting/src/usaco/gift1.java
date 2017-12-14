package usaco;

/*
ID: Max
LANG: JAVA
TASK: gift1
*/

import java.io.*;
import java.util.*;

public class gift1 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new FileReader("Files/In"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("Files/Out")));
		int numPeople = Integer.parseInt(reader.readLine());
		int[] recieved = new int[numPeople];  // how much everyone recieves
		int[] initial = new int[numPeople]; //how much everyone had
		String[] people = new String[numPeople];
		HashMap<String,Integer> key = new HashMap<String,Integer>(numPeople);
		//read in people's names
		for (int i = 0; i < numPeople;i++){
			people[i] = reader.readLine();
			key.put(people[i], i);  // keep track of who is where in the array
		}
		
		String giver;
		String[] temp;
		int total;
		int recipients;
		String recipient;
		
		//process transactions
		for (int i = 0; i < numPeople; i++){
			giver = reader.readLine();
			temp = reader.readLine().split(" ");
			total = Integer.parseInt(temp[0]);
			recipients = Integer.parseInt(temp[1]);
			initial[key.get(giver)] = total;
			//give each person their money
			for (int j = 0; j<recipients; j++){
				recipient = reader.readLine();
				recieved[key.get(recipient)] += total/recipients;
			}
			if (recipients > 0){
				recieved[key.get(giver)]+= total%recipients;
			}else{
				recieved[key.get(giver)] += total;
			}
			
		}
		for (int i = 0; i < numPeople; i++){
			out.println(people[i]+" "+(recieved[i]-initial[i]));
		}
		reader.close();
		out.close();
		System.exit(0);
	}

}
