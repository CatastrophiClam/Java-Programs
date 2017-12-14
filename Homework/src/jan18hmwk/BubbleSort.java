package jan18hmwk;
import java.util.Scanner;
import java.util.ArrayList;
public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		ArrayList<Double> list = new ArrayList<Double>();
		ArrayList<Double> pastList = new ArrayList<Double>();
		System.out.print("Enter the list of 10 numbers: ");
		for (int i = 0; i < 10; i++){
			list.add(scan.nextDouble());
		}
		while (!pastList.equals(list)){
			pastList = list;
			for (int i = 0; i < 9; i++){
				if (list.get(i)>list.get(i+1)){
					list.add(i, list.get(i+1));
					list.remove((int)(i+2));
				}
			}
		}
		for (double i : list){
			System.out.print(i+" ");
		}
	}

}
