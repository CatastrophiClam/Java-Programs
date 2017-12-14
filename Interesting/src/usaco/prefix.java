package usaco;
import java.util.*;
import java.io.*;

/*
ID: Max
LANG: JAVA
TASK: prefix
*/

public class prefix {
	
	static ArrayList<String> primitives = new ArrayList<String>();
	static String S;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		//BufferedReader reader = new BufferedReader(new FileReader("prefix.in"));
		//PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("prefix.out")));
		BufferedReader reader = new BufferedReader(new FileReader("Test.txt.txt"));
		PrintStream writer = System.out;
		//StopWatch watch = new StopWatch();
		String buffer;
		S = "";
		String[]bufferStrings;
		
		//watch.start();
		buffer = reader.readLine();
		while(!buffer.equals(".")){
			bufferStrings = buffer.split(" ");
			for (int i = 0; i < bufferStrings.length; i++){
				primitives.add(bufferStrings[i]);
			}
			buffer = reader.readLine();
		}
		
		for (int i = 0; i < primitives.size(); i++){
			if (isMakeable(primitives.get(i),primitives.get(i))){
				primitives.remove(i);
				i--;
			}
		}
		//System.out.println(primitives);
		
		buffer = reader.readLine();
		while(buffer!=null){
			S+=buffer;
			//System.out.println(S);
			buffer = reader.readLine();
		}
		
		int[] lengths = new int[S.length()];
		int temp;
		for (int i = S.length()-1; i >= 0; i--){
			for (String j:primitives){
				if (fits(j,i)){
					temp = j.length();
					if (i+j.length()<S.length()){
						temp += lengths[i+j.length()];
					}
					if (temp > lengths[i]){
						lengths[i]=temp;
					}
				}
			}
		}
		writer.println(lengths[0]);
		//watch.stop();
		//System.out.println(watch.timeElapsed());
		reader.close();
		writer.close();
		System.exit(0);
	}
	
	public static boolean isMakeable(String primitive, String actual){
		ArrayList<String> shorter = new ArrayList<String>();
		for (String i:primitives){
			if (i.length()<=primitive.length() && !i.equals(actual)){
				shorter.add(i);
			}
		}
		//System.out.printf("Primitive: %s, Actual: %s, Shorter: "+shorter+"\n", primitive,actual);
		for (String i:shorter){
			if (i.equals(primitive)){
				return true;
			}else{
				if (matches(i,primitive)){
					if (isMakeable(primitive.substring(i.length()),actual)){
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public static boolean matches(String a, String b){
		for (int i = 0; i < a.length(); i++){
			if (a.charAt(i)!=b.charAt(i)){
				return false;
			}
		}
		return true;
	}
	
	
	public static boolean fits(String s,int at){
		if (at+s.length()>S.length()){
			return false;
		}
		for (int i = 0; i < s.length(); i++){
			if (s.charAt(i)!=S.charAt(at+i)){
				return false;
			}
		}
		return true;
	}

}
