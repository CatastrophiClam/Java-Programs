import java.util.*;
import java.io.*;
public class problem2 {
	static int K;
	static char[] in;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(new File("DATA21.txt"));
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		for (int c = 0; c <10; c++){
			K = Integer.parseInt(reader.nextLine());
			String input = reader.nextLine();
			in = input.toCharArray();
			
			boolean isEncrypted = true;
			int numWords = 1;
			
			for (int i = 0; i < min(30,in.length); i++) {
				if (in[i] == ' ') {
					isEncrypted = false;
					break;
				}
			}
			int sum = 0;
			int temp;
			if (isEncrypted) {
				for (int i = in.length-1; i>=0; i--){
					temp = in[i]-'a'-(K+sum)%26;
					if (temp < 0){
						temp = temp+26;
					}
					in[i]=alphabet.charAt(temp);
					sum+=temp;
				}
				numWords = (in[0]-'a')*26+in[1]-'a';
				ArrayList<Integer> wordLens = new ArrayList<Integer>();
				for (int i = 2; i < numWords+2; i++){
					wordLens.add(in[i]-'a');
				}
				int counter = 0;
				int wordCounter = 0;
				for (int i = 2+numWords; i < in.length; i++){
					System.out.print(in[i]);
					counter++;
					if (counter == wordLens.get(wordCounter)){
						counter = 0;
						wordCounter++;
						System.out.print(" ");
					}
				}
				System.out.println();
			} else {
				ArrayList<Integer> wordLens = new ArrayList<Integer>();
				int letterCount = 0;
				for (int i = 0; i < in.length; i++){
					letterCount++;
					if (in[i]==' '){
						letterCount--;
						numWords++;
						wordLens.add(letterCount);
						letterCount = 0;
					}
				}
				wordLens.add(letterCount);
				char[] out = new char[in.length+3];
				out[0]=alphabet.charAt(numWords/26);
				out[1]=alphabet.charAt(numWords%26);
				for (int i = 2; i < numWords+2; i++){
					out[i]=alphabet.charAt(wordLens.get(i-2));
				}
				int adjust = numWords+2;
				for (int i = 0; i<in.length; i++){
					if (in[i]!=' '){
						out [i+adjust]=in[i];
					}else{
						adjust--;
					}
				}
				sum = 0;
				int tempSum;
				for (int i = out.length-1; i>=0;i--){
					tempSum = out[i]-'a';
					out[i]=alphabet.charAt((out[i]-'a'+K+sum)%26);
					sum += tempSum;
				}
				System.out.println(String.copyValueOf(out));
			}
		}
	}
	
	public static int min(int a, int b){
		if (a<b){
			return a;
		}
		return b;
	}
	
	public static int toBase26 (int n) {
		return n;
	}
}
