import java.util.*;
import java.io.*;
public class problem1 {
	static String in;

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(new File("DATA11.txt"));
		for (int t = 0; t < 10; t++){
		in = reader.nextLine();
		int min = 10000000;
		int temp;
		for (int i = 0; i < in.length(); i++){
			temp = check(i);
			if (temp < min){
				min = temp;
			}
		}
		System.out.println(min);
		}
	}
	
	public static int check(int i){
		int lower = i-1;
		int higher = i+1;
		int count = 0;
		int adjust=1;
		if (lower >= 0 && higher < in.length()){
			if (in.charAt(lower)==in.charAt(i)){
				lower = i-2;
				adjust = 2;
			}
			if (in.charAt(higher)==in.charAt(i)){
				higher = i+2;
				adjust = 2;
			}
			if (in.charAt(i-1)==in.charAt(i+1)){
				lower = i-1;
				higher = i+1;
				adjust = 1;
			}
		}
		while (lower >= 0 && higher < in.length()){
			if (in.charAt(lower)==in.charAt(higher)){
				count+=2;
				lower--;
				higher++;
			}else{
				return 10000000;
			}
		}
		return in.length()-count-adjust;
	}

}
