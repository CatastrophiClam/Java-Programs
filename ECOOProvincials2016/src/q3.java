import java.util.*;
import java.io.*;
public class q3 {
	static int maxLen = 0;
	static HashSet<String> dict;
	
	public static void main(String[] args) throws IOException {
		Scanner reader = new Scanner(new File("DATA31.txt"));
		int N = Integer.parseInt(reader.nextLine());
		dict = new HashSet<String>(N);
		String temp;
		
		for (int i = 0; i < N; i++){
			temp = reader.nextLine();
			if(temp.length()>maxLen){
				maxLen = temp.length();
			}
			dict.add(temp);
		}
		String str;
		for (int c = 0; c < 10; c++){
			str = reader.nextLine();
			System.out.println(find(-1,0,str));
		}
	}
	
	public static int find(int numWords, int startIndex, String string){
		String str = "";
		ArrayList<Integer> inds = new ArrayList<Integer>();
		for (int i = startIndex; i < min(maxLen+startIndex,string.length()); i++){
			str=string.substring(startIndex,i+1);
			if (dict.contains(str)){
				inds.add(i);
			}
		}
		int temp;
		int max= 100000000;
		for (int i = inds.size()-1; i >= 0; i--){
			if (inds.get(i)==string.length()-1){
				return numWords+1;
			}else{
				temp = find(numWords+1,inds.get(i)+1,string);
				if (temp!=100000000){
					if (temp < max){
						max = temp;
					}
				}
			}
		}
		return max;
	}
	
	public static int min(int a, int b){
		if (a<b){
			return a;
		}
		return b;
	}
	
}
