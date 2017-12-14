package ccc;
import java.io.*;
import java.util.Scanner;
import java.util.HashMap;

public class s2_2010 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		File file = new File("test.txt.txt");
		Scanner reader = new Scanner(file);
		int numCodes = Integer.parseInt(reader.nextLine());
		String[]temp;
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		for (int i = 0; i < numCodes; i++){
			temp = reader.nextLine().split(" ");
			map.put(Integer.parseInt(temp[1]), temp[0]);
		}
		String code = reader.nextLine();
		int lastInd = 0;
		for (int i = 0; i < code.length(); i++){
			if (map.containsKey(Integer.parseInt(code.substring(lastInd, i+1)))){
				System.out.print(map.get(Integer.parseInt(code.substring(lastInd, i+1))));
				lastInd = i+1;
			}
		}
	}

}
