package Tests;
import java.util.Scanner;
import java.util.ArrayList;
public class Test4 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(6);
		list.add(5);
		list.add(2);
		Scanner scan = new Scanner(System.in);
		double d = scan.nextDouble();
		System.out.println(d);
	}
	
	public static int binSearch(int a, ArrayList<Integer> list){
		int min = 0;
		int max = list.size();
		int findIndex;
		while (true){
			findIndex = (min+max)/2;
			if (list.get(findIndex)==a){
				return findIndex;
			}else if (list.get(findIndex)<a){
					min = findIndex+1;
			}else{
				max = findIndex;
			}
		}
	}
	
	public static int findInsertPos(int a, ArrayList<Integer> list){
		int min = 0;
		int max = list.size();
		int findIndex;
		while (true){
			if (max==0){
				return 0;
			}else if(max == 1){
				if (a >= list.get(0)){
					return 1;
				}else{
					return 0;
				}
			}else{
				findIndex = (min+max)/2;
				if (findIndex == 0){
					if (a <= list.get(0)){
						return 0;
					}else{
						min = 1;
					}
				}else if (findIndex == list.size()-1){
					if (list.get(findIndex)>=a){
						if (list.get(findIndex-1)<=a){
							return findIndex;
						}else{
							max = findIndex-1;
						}
					}else{
						return findIndex+1;
					}
				}else if (list.get(findIndex-1)<=a){
					if (list.get(findIndex)>=a){
						return findIndex;
					}else{
						min = findIndex;
					}
				}else{
					max = findIndex;
				}
			}
		}
	}

}
