import java.util.*;
import java.lang.Math;
public class s2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = 0; i < N; i++){
			arr.add(scan.nextInt());
		}
		arr.sort(null);
		int half = (int)(Math.ceil(N/2.0)-1);
		for (int i = 0; i < N/2; i++){
			System.out.print(arr.get(half-i)+" ");
			System.out.print(arr.get(i+half+1));
			if (i != N/2-1){
				System.out.print(" ");
			}
		}
		if (N%2==1){
			System.out.print(" "+arr.get(0));
		}
		System.out.println();
	}

}
