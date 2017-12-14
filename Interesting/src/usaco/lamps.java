package usaco;
import java.util.*;
import java.io.*;
import java.lang.Math;
import java.math.BigInteger;

/*
ID: Max
LANG: JAVA
TASK: lamps
*/

public class lamps {
	
	static int[] lampsOff;
	static int[] lampsOn;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new FileReader("lamps.in"));
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("lamps.out")));
		//BufferedReader reader = new BufferedReader(new FileReader("Test.txt.txt"));
		//PrintStream writer = System.out;
		int numLamps = Integer.parseInt(reader.readLine());
		int timesChanged = Integer.parseInt(reader.readLine());
		
		String[] buffer = new String[100];
		buffer = reader.readLine().split(" ");
		int length = 0;
		while (!buffer[length].equals("-1")){
			length++;
		}
		lampsOn = new int[length];
		for (int i = 0; i < length; i++){
			lampsOn[i] = Integer.parseInt(buffer[i]);
		}
		
		buffer = reader.readLine().split(" ");
		length = 0;
		while (!buffer[length].equals("-1")){
			length++;
		}
		lampsOff = new int[length];
		for (int i = 0; i < length; i++){
			lampsOff[i] = Integer.parseInt(buffer[i]);
		}
		
		//start logic
		ArrayList<int[]> combs;
		if (timesChanged == 0){
			combs = new ArrayList<int[]>();
			combs.add(new int[]{});
		}else if (timesChanged <= 2){
			if (timesChanged==1){
				combs = getCombs(1);
			}else{
				combs = getCombs(0,2);
			}
		}else if (timesChanged%2 == 0){
			combs = getCombs(0,2,4);
		}else{
			combs = getCombs(1,3);
		}
		/**
		for (int[] i:combs){
			for (int j:i){
				System.out.print(j);
			}
			System.out.println();
		}
		**/
		
		boolean impossible = true;
		boolean[] lamps = new boolean[numLamps]; //false means on
		HashMap<BigInteger,boolean[]> map = new HashMap<BigInteger,boolean[]>();
		ArrayList<BigInteger> nums = new ArrayList<BigInteger>();
		for (int[] i : combs){
			lamps = process(i,lamps.length);
			if (check(lamps)){
				/**
				for (boolean j:lamps){
					if (j){
						System.out.print(0);
					}else{
						System.out.print(1);
					}
				}
				System.out.print(" ");
				for (int j:i){
					System.out.print(j+" ");
				}
				System.out.println();
				**/
				impossible = false;
				nums.add(toNum(lamps));
				map.put(nums.get(nums.size()-1), lamps);
			}
		}
		Collections.sort(nums);
		
		boolean[] toPrint;
		for (BigInteger i: nums){
			toPrint = map.get(i);
			for (boolean j: toPrint){
				if (j){
					writer.print(0);
				}else{
					writer.print(1);
				}
			}
			writer.println();
		}
		if (impossible){
			writer.println("IMPOSSIBLE");
		}
		reader.close();
		writer.close();
		System.exit(0);
	}
	
	public static boolean check(boolean[] lamps){
		for (int i:lampsOn){
			if (lamps[i-1]){
				return false;
			}
		}
		for (int i : lampsOff){
			if (!lamps[i-1]){
				return false;
			}
		}
		return true;
	}
	
	public static BigInteger toNum(boolean[] arr){
		BigInteger total = new BigInteger("0");
		for (int i = arr.length-1; i >= 0; i--){
			if (!arr[i]){
				BigInteger temp = new BigInteger("2");
				total = total.add(temp.pow(arr.length-1-i));
			}
		}
		return total;
	}
	
	public static boolean[] process(int[] actions, int len){
		boolean[] answer = new boolean[len];
		for (int i:actions){
			switch(i){
			case 1:
				for (int j = 0; j < len; j++){
					answer[j]=!answer[j];
				}
				break;
			case 2:
				for (int j = 0; j < len; j+=2){
					answer[j] = !answer[j];
				}
				break;
			case 3:
				for (int j = 1; j < len; j+=2){
					answer[j] = !answer[j];
				}
				break;
			case 4:
				for (int j = 0; j < len; j+=3){
					answer[j]=!answer[j];
				}
				break;
			}
		}
		return answer;
	}
	
	public static ArrayList<int[]> getCombs(int ... possibilities){
		ArrayList<int[]> combs = new ArrayList<int[]>();
		for (int i: possibilities){
			if (i == 1){
				combs.add(new int[]{1});
				combs.add(new int[]{2});
				combs.add(new int[]{3});
				combs.add(new int[]{4});
			}else if (i==2){
				combs.add(new int[]{1,2});
				combs.add(new int[]{1,3});
				combs.add(new int[]{1,4});
				combs.add(new int[]{2,3});
				combs.add(new int[]{2,4});
				combs.add(new int[]{3,4});
			}else if(i == 3){
				combs.add(new int[]{1,2,3});
				combs.add(new int[]{1,2,4});
				combs.add(new int[]{1,3,4});
				combs.add(new int[]{2,3,4});
			}else if(i == 4){
				combs.add(new int[]{1,2,3,4});
			}else{
				combs.add(new int[]{});
			}
		}
		return combs;
	}
}
