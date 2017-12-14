package ccc;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Math;
public class s3_2012 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		File file = new File("Test.txt.txt");
		Scanner reader = new Scanner(file);
		int numSensors = reader.nextInt();
		int[] freqs = new int[1000];
		int maxFreq = 0;
		int secMaxFreq = 0;
		ArrayList<Integer> maxList = new ArrayList<Integer>();
		ArrayList<Integer> secMaxList = new ArrayList<Integer>();
		int temp;
		for (int i = 0; i < numSensors; i++){
			temp = reader.nextInt();
			freqs[temp-1] ++;
			if (freqs[temp-1]>maxFreq){
				maxFreq++;
				for (int j : maxList){
					secMaxList.add(j);
				}
				maxList.clear();
				maxList.add(temp);
			}else if(freqs[temp-1] == maxFreq){
				maxList.add(temp);
			}else if (freqs[temp-1]>secMaxFreq){
				secMaxFreq++;
				secMaxList.clear();
				secMaxList.add(temp);
			}else if(freqs[temp-1]==secMaxFreq){
				secMaxList.add(temp);
			}
		}
		int largest1 = -1;
		int smallest1 = 2000001;
		for (int i : maxList){
			if (i > largest1){
				largest1 = i;
			}
			if (i < smallest1){
				smallest1 = i;
			}
		}
		int largest2 = -1;
		int smallest2 = 2000001;
		for (int i : secMaxList){
			if (i < smallest2){
				smallest2 = i;
			}
			if (i>largest2){
				largest2 = i;
			}
		}
		int diff1 = Math.abs(largest1-smallest2);
		int diff2 = Math.abs(largest2-smallest1);
		
		System.out.print(Math.max(diff1, diff2));
	}

}
