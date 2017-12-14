import java.util.Scanner;
public class s1 {
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		int a = 0;
		int b = 0;
		int k = 0;
		int[] arr = new int[N];
		for (int i = 0; i < N; i++){
			arr[i] = scan.nextInt();
		}
		for (int i = 0; i < N; i++){
			a += arr[i];
			b += scan.nextInt();
			if (a== b){
				k = i+1;
			}
		}
		System.out.println(k);
	}
}
