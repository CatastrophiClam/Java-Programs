package jan18hmwk;
import java.util.Scanner;
import java.util.ArrayList;
public class MergeLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		int [] list1;
		int [] list2;
		int [] mList;
		ArrayList<Integer> totList = new ArrayList<Integer>();
		System.out.println("Enter list 1: ");   // create 2 lists
		int iterator = scan.nextInt();
		list1 = new int[iterator];
		for (int i = 0; i < iterator; i++){
			list1[i] = scan.nextInt();
		}
		System.out.println("Enter list 2: ");
		iterator = scan.nextInt();
		list2 = new int[iterator];
		for (int i = 0; i < iterator; i++){
			list2[i] = scan.nextInt();
		}
		mList = new int[list1.length+list2.length];
		for (int i=0; i < list1.length; i++){
			totList.add(list1[i]);
		}
		for (int i:list2){
			for (int j : totList){
				if (i > j){
					totList.add(totList.lastIndexOf(j)+1, i);
				}
			}
		}
		for (int i:totList){
			System.out.print(i+" ");
		}
	}

}
