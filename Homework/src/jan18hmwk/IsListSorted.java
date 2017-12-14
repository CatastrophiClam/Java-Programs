package jan18hmwk;
import java.util.Scanner;
import java.util.ArrayList;
public class IsListSorted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<Integer>();
		boolean isSorted = true; // list is sorted until proved otherwise
		System.out.print("Enter list: ");
		int length = scan.nextInt();
		for (int i = 0; i<length; i++){
			list.add(scan.nextInt());
		}
		for (int i:list){
			if (list.indexOf(i)!= list.lastIndexOf(i)-count(list, i)+1)
				isSorted = false;
				break;
		}
		if (isSorted)
			System.out.print("The list is sorted");
		else
			System.out.print("The list is not sorted");
	}
	
	public static int count(ArrayList<Integer> list, int counted){
		int count = 0;
		for (int i:list){
			if (i == counted)
				count++;
		}
		return count;
	}

}
