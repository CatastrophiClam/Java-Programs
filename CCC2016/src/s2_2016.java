import java.util.*;
import java.io.*;
public class s2_2016 {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in);
		int question = reader.nextInt();
		int N = reader.nextInt();
		ArrayList<Integer> a = new ArrayList<Integer>();
		ArrayList<Integer> b = new ArrayList<Integer>();
		for (int i = 0; i < N; i++){
			a.add(reader.nextInt());
		}
		for (int i = 0; i < N; i++){
			b.add(reader.nextInt());
		}
		a.sort(null);
		b.sort(null);
		if (question==1){
			int min = 0;
			for (int i = 0; i < N; i++){
				min += max(a.get(i),b.get(i));
			}
			System.out.println(min);
		}else{
			int max = 0;
			for (int i = 0; i < N; i++){
				max += max(a.get(i),b.get(N-1-i));
			}
			System.out.println(max);
		}
	}
	
	public static int max(int a, int b){
		if (a > b){
			return a;
		}
		return b;
	}

}
