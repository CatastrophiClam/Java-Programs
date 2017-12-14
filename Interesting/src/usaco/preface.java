package usaco;
import java.util.*;
import java.io.*;

/*
ID: Max
LANG: JAVA
TASK: preface
*/

public class preface {
	
	static int[] totalCounts;
	static int[][] numCounts;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		//Scanner reader = new Scanner(System.in);
		//PrintWriter writer = new PrintWriter(System.out);
		BufferedReader reader = new BufferedReader(new FileReader("preface.in"));
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("preface.out")));
		int N = Integer.parseInt(reader.readLine());
		//int N = Integer.parseInt(reader.nextLine());
		totalCounts = new int[7];
		numCounts = new int[N][7];
		for (int i = 1; i <= N; i++){
			accumulate(i);
		}
		String[] letters = {"I", "V", "X", "L", "C", "D", "M"};
		
		int max = 6;
		while(totalCounts[max]==0){
			max--;
		}
		
		for (int i = 0; i <= max; i++){
			writer.println(letters[i]+" "+totalCounts[i]);
		}
		reader.close();
		writer.close();
		System.exit(0);
	}
	
	public static void accumulate(int num){
		int left;
		int place;
		int remainder;
		if (num < 10){
			remainder = 0;
			left = num;
			place = 0;
		}else if(num < 100){
			remainder = num%10;
			left = (num - remainder)/10;
			place = 2;
		}else if(num < 1000){
			remainder = num%100;
			left = (num - remainder)/100;
			place = 4;
		}else{
			remainder = num%1000;
			left = (num - remainder)/1000;
			place = 6;
		}
		switch (left){
		case 1:
			totalCounts[place]++;
			numCounts[num-1][place]++;
			break;
		case 2:
			totalCounts[place]+=2;
			numCounts[num-1][place]+=2;
			break;
		case 3:
			totalCounts[place]+=3;
			numCounts[num-1][place]+=3;
			break;
		case 4:
			totalCounts[place+1]++;
			totalCounts[place]++;
			numCounts[num-1][place]++;
			numCounts[num-1][place+1]++;
			break;
		case 5:
			totalCounts[place+1]++;
			numCounts[num-1][place+1]++;
			break;
		case 6:
			totalCounts[place+1]++;
			totalCounts[place]++;
			numCounts[num-1][place]++;
			numCounts[num-1][place+1]++;
			break;
		case 7:
			totalCounts[place]+=2;
			numCounts[num-1][place]+=2;
			totalCounts[place+1]++;
			numCounts[num-1][place+1]++;
			break;
		case 8:
			totalCounts[place]+=3;
			numCounts[num-1][place]+=3;
			totalCounts[place+1]++;
			numCounts[num-1][place+1]++;
			break;
		case 9:
			totalCounts[place+2]++;
			numCounts[num-1][place+2]++;
			totalCounts[place]++;
			numCounts[num-1][place]++;
			break;
		}
		if (remainder != 0){
			add(numCounts[remainder-1],totalCounts);
			add(numCounts[remainder-1],numCounts[num-1]);
		}
	}
	
	//adds ints in a to b
	public static void add(int[] a, int [] b){
		for (int i = 0; i < a.length; i++){
			b[i]+=a[i];
		}
	}

}
