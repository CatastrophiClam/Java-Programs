package jan18hmwk;
import java.util.Scanner;
public class ReverseArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int [] array = new int[10];
		System.out.print("Enter 10 numbers: ");
		for(int i = 0; i < 10; i ++){
			array[i] = scan.nextInt();
		}
		System.out.print("The reverse of this array is: ");
		for (int i: reverse(array)){
			System.out.print(i+" ");
		}
	}
	
	public static int[] reverse(int[] start){
		int[] finish = new int[start.length];
		for(int i =0; i<start.length; i++){
			finish[i] = start[start.length-1-i];
		}
		return finish;
	}

}
