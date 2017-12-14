package usaco;

/*
ID: Max
LANG: JAVA
TASK: namenum
*/

import java.util.*;
import java.io.*;


public class namenum {
	
	static PrintWriter writer;
	static String name = "";
	static String[][] letters = {{},{},{"A","B","C",},{"D","E","F",},{"G","H","I"},{"J","K","L"},{"M","N","O"},{"P","R","S"},{"T","U","V"},{"W","X","Y"}};
	static String nums;
	static HashSet<String> set = new HashSet<String>();
	static boolean printed = false;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new FileReader("Files/In"));
		writer = new PrintWriter(new BufferedWriter(new FileWriter("Files/Out")));
		BufferedReader dictReader = new BufferedReader(new FileReader("Files/dict.txt"));
		boolean flag = true;
		String temp;
		nums = reader.readLine();
		//read in valid names
		while(flag){
			temp = dictReader.readLine();
			if (temp != null){
				set.add(temp);
			}else{
				break;
			}
		}
		tryAll(0);
		if (!printed){
			writer.println("NONE");
		}
		reader.close();
		writer.close();
		dictReader.close();
		System.exit(0);
	}
	//recursively tries all possibilities for nums
	static void tryAll(int index){
		String temp = name;
		for (String i:letters[Integer.parseInt(nums.substring(index,index+1))]){
			name += i;
			if (index == nums.length()-1){
				if (set.contains(name)){
					writer.println(name);
					printed = true;
				}
			}else{
				tryAll(index+1);
			}
			name = temp;
		}
	}
}
