import java.util.*;
import java.lang.Math;
public class s3 {
	private static int[]wood;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		wood = new int[2001];
		int temp;
		for (int i = 0; i < N; i++){
			temp = scan.nextInt();
			wood[temp]++;
		}
		
		int maxLen = 0;
		int maxLenCount = 0;
		int[] combs = new int[4001];
		for (int i = 2; i < 4001; i++){
			for (int j = max(1,i-2000); j < Math.ceil(i/2.0); j++){
				combs[i] += min(wood[j],wood[i-j]);
			}
			if (i%2==0){
				combs[i]+=wood[i/2]/2;
			}
			if (combs[i]>maxLen){
				maxLen = combs[i];
			}
		}
		for (int i = 1; i < 4001; i++){
			if (combs[i]==maxLen){
				maxLenCount++;
			}
		}
		System.out.println(maxLen + " "+maxLenCount);
		//for (int i = 1; i < 10; i++){
		//	System.out.print(combs[i]+" ");
		//}
	}
	
	public static int max(int a, int b){
		if (a > b){
			return a;
		}
		return b;
	}
	
	public static int min(int a, int b){
		if (a < b){
			return a;
		}
		return b;
	}

}
