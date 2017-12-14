package challenges;
import java.util.*;

public class BabyTalkLongestSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String str = scan.nextLine();
		ArrayList<Integer> freq = new ArrayList<Integer>();
		ArrayList<String> keys = new ArrayList<String>();
		char past = '*';
		char current;
		int count = 0;
		for (int i = 0; i < str.length();i++){
			current = str.charAt(i);
			if (current == past){
				count++;
			}else{
				freq.add(count);
				count = 1;
				keys.add(String.valueOf(past));
				past = current;
			}
		}
		freq.add(count);
		keys.add(String.valueOf(past));
		freq.remove(0);
		keys.remove(0);
	}

}
