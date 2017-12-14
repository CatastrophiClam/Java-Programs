package challenges;
import java.util.*;
import java.io.*;


public class Q3_8No6 {
	
	static HashMap<Integer,ArrayList<String>>dict = new HashMap<Integer,ArrayList<String>>();
	static ArrayList<Integer> lengthPairs = new ArrayList<Integer>(); 
	static int fileLength = 0; //length of a whole file
	static int numFiles = 0;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader reader = new BufferedReader(new FileReader("Files/In"));
		PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter("Files/Out")));
		int numCases = Integer.parseInt(reader.readLine());
		reader.readLine();
		for (int i = 0; i < numCases; i++){
			process(reader,writer);
		}
		System.out.print("Yes");
	}
	
	public static void process(BufferedReader reader, PrintWriter writer) throws IOException{
		ArrayList<String> list = new ArrayList<String>();		
		String temp;
		while (true){
			temp = reader.readLine();
			if (temp==null){
				break;
			}else{
				list.add(temp);
			}
		}
		int length;
				
		//compute the length of each file and update numFiles
		for (int i = 0; i < list.size(); i++){
			fileLength += list.get(i).length();
			numFiles++;
		}
		fileLength = fileLength/list.size()*2;
		
		//map all the fragments to their lengths in a hashmap, record half of all the lengths (one from each complementary
		//pair that adds up to the file length)
		for (int i = 0; i < list.size(); i++){
			length = list.get(i).length();
			if (dict.containsKey(length)){
				dict.get(length).add(list.get(i));
			}else{
				dict.put(length, new ArrayList<String>());
				dict.get(length).add(list.get(i));
			}
			if (!lengthPairs.contains(length)&&!lengthPairs.contains(fileLength-length)){
				lengthPairs.add(length);
			}
		}
		String correct;
		ArrayList<String> a;
		ArrayList<String> b;
		String aS;
		String bS;
		// for every combination of the first complementary pair, make a 'correct' file and see if it works
		for (int i = 0; i < dict.get(lengthPairs.get(0)).size();i++){
			for (int j = 0; j < dict.get(fileLength-lengthPairs.get(0)).size();j++){
				a = dict.get(lengthPairs.get(0));
				b = dict.get(fileLength-lengthPairs.get(0));
				aS = a.get(i);
				bS = b.get(j);
				correct = aS+bS;
				a.remove(i);
				b.remove(j);
				if (compareToAll(correct)){
					System.out.print(correct);
					return;
				}
				correct = bS+aS;
				if (compareToAll(correct)){
					System.out.print(correct);
					return;
				}
				
				a.add(aS);
				b.add(bS);
			}
		}
		
	}
	
	public static boolean compareToAll(String correct){
		ArrayList<String> a;
		ArrayList<String> b;
		String aS;
		String bS;
		if (numFiles == 0){
			return true;
		}
		for (int i = 0; i < lengthPairs.size();i++){
			for (int j = 0; j < dict.get(lengthPairs.get(i)).size();j++){
				for (int k = 0; k < dict.get(fileLength-lengthPairs.get(i)).size();k++){
					a = dict.get(lengthPairs.get(i));
					b = dict.get(fileLength-lengthPairs.get(i));
					aS = a.get(i);
					bS = b.get(j);
					if ((aS+bS).equals(correct)||(bS+aS).equals(correct)){
						a.remove(i);
						b.remove(j);
						numFiles -= 2;
						if (compareToAll(correct)){
							return true;
						}
						a.add(aS);
						b.add(bS);
						numFiles += 2;
					}
				}
			}
			//return false;
		}
		return false;
	}

}
