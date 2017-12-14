import java.util.*;
import java.io.*;
public class VignereSolver {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(new File("Files/dict.txt"));
		String text = "loevsfdavqzpnllyvnwfwzedq";
		String key;
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		String up = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String answer = "";
		int index;
		HashMap<Character,Integer> map = new HashMap<Character,Integer>();
		for (int i = 0; i < 26; i++){
			map.put(alphabet.charAt(i), i);
			map.put(up.charAt(i),i);
		}
		while (reader.hasNextLine()){
			answer = "";
			key = reader.nextLine();
			for (int i = 0; i < text.length(); i++){
				index = map.get(text.charAt(i))-map.get(key.charAt(i%key.length()));
				if (index < 0){
					index += 26;
				}
				answer += alphabet.substring(index, index+1);
			}
			if (answer.contains("the") || answer.contains("sun")){
				System.out.println(key+": "+answer);
			}
		}
	}

}
