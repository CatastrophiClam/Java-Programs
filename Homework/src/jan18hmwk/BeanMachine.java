package jan18hmwk;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
public class BeanMachine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the number of balls to drop: ");
		int ballNum = scan.nextInt();
		System.out.println("Enter the number of slots: ");
		int slotNum = scan.nextInt();
		BeanMachineLogic bML = new BeanMachineLogic(slotNum, ballNum);
		ArrayList<Integer> frequencies = bML.getFrequencies();
		ArrayList<ArrayList<String>> paths = bML.getPaths();
		System.out.println();
		for (ArrayList<String>i : paths){
			for (String j : i){
				if (j.equals("0"))
					System.out.print("L");
				else
					System.out.print("R");
			}
			System.out.println();
		}
		for (int i = 0; i < Collections.max(frequencies); i++){   // print out balls
			for (int j:frequencies){
				if (Collections.max(frequencies) - i <= j)
					System.out.print("O");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
		
	}

}
