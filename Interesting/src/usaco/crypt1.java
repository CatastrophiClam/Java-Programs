package usaco;
import java.util.*;
import java.io.*;

/*
ID: Max
LANG: JAVA
TASK: crypt1
*/

public class crypt1 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new FileReader("crypt1.in"));
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("crypt1.out")));
		
		HashSet<Character> set = new HashSet<Character>();
		int numDigits = Integer.parseInt(reader.readLine());
		int[] digits = new int[numDigits];
		String[] temp = reader.readLine().split(" ");
		for (int i = 0; i < numDigits; i++){
			digits[i] = Integer.parseInt(temp[i]);
			set.add((char)(digits[i]+48));
		}
		
		String answer;
		String p1;
		String p2;
		int count = 0;
		for (int a = 0; a < numDigits; a++){
			for (int b = 0; b < numDigits; b++){
				for (int c = 0; c < numDigits; c++){
					for (int d = 0; d < numDigits; d++){
						outer:
						for (int e = 0; e < numDigits; e++){
							answer = String.valueOf((digits[a]*100+digits[b]*10+digits[c])*(digits[d]*10+digits[e]));
							p1 = String.valueOf(digits[e]*(digits[a]*100+digits[b]*10+digits[c]));
							p2 = String.valueOf(digits[d]*(digits[a]*100+digits[b]*10+digits[c]));
							if (p1.length()>3||p2.length()>3){
								continue outer;
							}
							for (int i = 0; i < answer.length(); i++){
								if (!set.contains(answer.charAt(i))){
									continue outer;
								}
							}
							for (int i = 0; i < p1.length(); i++){
								if (!set.contains(p1.charAt(i))){
									continue outer;
								}
							}
							for (int i = 0; i < p2.length(); i++){
								if (!set.contains(p2.charAt(i))){
									continue outer;
								}
							}
							
							count++;
							//System.out.println(digits[a]+""+digits[b]+""+digits[c]+" * "+digits[d]+""+digits[e]);
							//System.out.println(p1);
							//System.out.println(p2);
							//System.out.println(answer);
						}
					}
				}
			}
		}
		writer.println(count);
		reader.close();
		writer.close();
		System.exit(0);
	}

}
